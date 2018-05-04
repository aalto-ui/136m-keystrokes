package controllers

import javax.inject._

import models.TestResults
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.routing._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.ws.WSClient
import services.TypingTestService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
//import play.api.i18n.Messages.Implicits._
//import play.api.Play.current

case class KeystrokeSubmit(pressTime: Long, releaseTime: Long, keycode: Int, letter: String)
case class QuestionnaireData(age: Int, gender: String, hasTakenTypingCourse: String, fingers: String, timeSpentTyping: Int,
                          layout: String, keyboardType: String, nativeLanguage: String, country: String, state: String)

@Singleton
class TypingTest @Inject()(testService: TypingTestService, ws: WSClient) extends Controller {

  case class BrowserDataSubmit(os: String, osVersion: Option[String], browser: String, browserVersion: Option[String])
  case class GeoData(countryCode: String, regionCode: String)

  val uidMissingResponse = BadRequest(Json.toJson(Map("status" -> "Bad Request", "error" -> "uid_missing_err")))
  val tsidMissingResponse = BadRequest(Json.toJson(Map("status" -> "Bad Request", "error" -> "tsid_missing_err")))
  val validationErrorResponse = BadRequest(Json.toJson(Map("status" -> "Bad Request", "error" -> "validation_err")))

  def consent = Action { implicit request =>
    Ok(views.html.consent(request)).withHeaders("P3P" -> "CP=\"Deprecated\"")
  }

  def instructions = Action { implicit request =>
    Ok(views.html.instructions(request)).withHeaders("P3P" -> "CP=\"Deprecated\"")
  }

  def typingTest = Action { implicit request =>
    Ok(views.html.typingtest(request)).withHeaders("P3P" -> "CP=\"Deprecated\"")
  }

  def questionnaire = Action { implicit request =>
    Ok(views.html.questionnaire(questionnaireForm)).withHeaders("P3P" -> "CP=\"Deprecated\"")
  }

  def uidErr = Action { implicit request =>
    Ok(views.html.uidErr(request)).withHeaders("P3P" -> "CP=\"Deprecated\"")
  }

  val questionnaireForm = Form(
    mapping(
      "age" -> number(min = 0, max = 120),
      "gender" -> text,
      "hasTakenTypingCourse" -> text,
      "fingers" -> text,
      "timeSpentTyping" -> number,
      "layout" -> text,
      "keyboardType" -> text,
      "nativeLanguage" -> text,
      "country" -> text,
      "state"-> text
    )(QuestionnaireData.apply)(QuestionnaireData.unapply)
  )

  def results = Action.async { implicit request =>
    request.session.get("uid") match {
      case Some(uid) => {
        for {
          fastest <- testService.getFastestSentence(uid)
          slowest <- testService.getSlowestSentence(uid)
          worst <- testService.getBiggestError(uid)
          wpm <- testService.getWPM(uid)
          errorRate <- testService.getErrorRate(uid)
        } yield {
          (fastest, slowest) match {
            case ((Some(sFastest), Some(sFastestError), Some(sFastestWpm)), (Some(sSlowest), Some(sSlowestError), Some(sSlowestWpm))) => {
              Ok(views.html.results(TestResults(wpm.toInt, errorRate, worst._1, worst._2, worst._3, worst._4, sFastest, sFastestError, sFastestWpm, sSlowest, sSlowestError, sSlowestWpm)))
                .withHeaders(CACHE_CONTROL -> "no-cache", "P3P" -> "CP=\"Deprecated\"")
            }
          }
        }
      }
      case None => Future(uidMissingResponse)
    }
  }

  def typingtestRoutes = Action { implicit request =>
    Ok(
        JavaScriptReverseRouter("typingtestRoutes")(
          routes.javascript.TypingTest.newUid,
          routes.javascript.TypingTest.sentence,
          routes.javascript.TypingTest.getWPM,
          routes.javascript.TypingTest.getErrorRate,
          routes.javascript.TypingTest.updateStats
        )
    ).as("text/javascript")
  }

  def newUid = Action.async { implicit request =>
    testService.newUid().map(s => {
      Ok(Json.toJson(Map("uid" -> s)))
        .withSession("uid" -> s)
        .withHeaders(CACHE_CONTROL -> "no-cache")
    })
  }

  def sentence(first: Boolean) = Action.async {
    implicit request => {
      (request.session.get("uid"), request.session.get("count"), request.session.get("tsid"),first) match {
        // new sentence in the middle of the test
        case (Some(uid), Some(count), _, false) => testService.newSentence(uid).map(map => {
          map.get("id") match {
            case Some(id) => Ok(Json.toJson(map + ("count" -> (count.toInt + 1).toString)))
              .withSession(request.session + ("count" -> (count.toInt + 1).toString) + ("tsid" -> id))
              .withHeaders(CACHE_CONTROL -> "no-cache")
            case _ => tsidMissingResponse
          }
        })
        // new sentence at the beginning of the test
        case (Some(uid), None, _, true) => testService.newSentence(uid).map(map => {
          map.get("id") match {
            case Some(id) => Ok(Json.toJson(map + ("count" -> (1).toString)))
              .withSession(request.session + ("count" -> "1") + ("tsid" -> id))
              .withHeaders(CACHE_CONTROL -> "no-cache")
            case _ => tsidMissingResponse
          }
        })
        // old sentence
        case (Some(uid), Some(count), Some(tsid), true) => testService.getSentence(tsid).map(map => {
          Ok(Json.toJson(map + ("count" -> count)))
            .withSession(request.session + ("count" -> count) + ("tsid" -> tsid))
            .withHeaders(CACHE_CONTROL -> "no-cache")
        })
        case _ => Future(uidMissingResponse)
      }
    }
  }

  def getWPM = Action.async {
    implicit request => {
      request.session.get("uid") match {
        case Some(uid) => testService.getWPM(uid).map(wpm => Ok(Json.toJson(Map("wpm" -> wpm.toInt))).withHeaders(CACHE_CONTROL -> "no-cache"))
        case None => Future(uidMissingResponse)
      }
    }
  }

  def updateStats = Action {
    implicit request => {
      request.session.get("uid") match {
        case Some(uid) => {
          request.session.get("questionnaire") match {
            case Some(q) => {
              testService.updateUserStats(uid)
              Ok(Json.toJson(Map("status" -> "OK", "questionnaire" -> "true"))).withSession(request.session - "count")
            }
            case None => {
              testService.updateUserStats(uid)
              Ok(Json.toJson(Map("status" -> "OK", "questionnaire" -> "false"))).withSession(request.session - "count")
            }
          }
        }
        case None => uidMissingResponse
      }
    }
  }

  def getErrorRate = Action.async {
    implicit request => {
      request.session.get("uid") match {
        case Some(uid) => testService.getErrorRate(uid).map(errorRate => Ok(Json.toJson(Map("errorRate" -> errorRate))).withHeaders(CACHE_CONTROL -> "no-cache"))
        case None => Future(uidMissingResponse)
      }
    }
  }

  def saveKeystroke = Action(BodyParsers.parse.json) { request =>
    val keystroke = request.body.validate[KeystrokeSubmit]
    keystroke.fold(
      errors => validationErrorResponse,
      keystroke => {
        request.session.get("tsid") match {
          case Some(tsid) => {
            testService.submitKeystroke(keystroke.pressTime, keystroke.releaseTime, keystroke.keycode, keystroke.letter, tsid)
            Ok(Json.obj("status" -> "OK"))
          }
          case None => tsidMissingResponse
        }

      }
    )
  }

  def saveKeystrokes = Action.async(BodyParsers.parse.json) {
    implicit request => {
      val keystrokes = (request.body \ "keystrokes").as[Seq[KeystrokeSubmit]]
      request.session.get("tsid") match {
        case Some(tsid) => {
          testService.submitKeystrokes(tsid, keystrokes).map {
            unit => {
              Ok(Json.obj("status" -> "OK"))
            }
          }
        }
        case None => Future(tsidMissingResponse)
      }
    }
  }

  def saveUserInput = Action.async(BodyParsers.parse.json) {
    request => {
      (request.body \ "userInput").validate[String] match {
        case s: JsSuccess[String] => {
          request.session.get("tsid") match {
            case Some(tsid) => {
              testService.submitUserInput(tsid, s.get).map(unit => {
                Ok(Json.obj("status" -> "OK"))
              })
            }
            case None => Future(tsidMissingResponse)
          }
        }
        case e: JsError => Future(validationErrorResponse)
      }
    }
  }

//  def saveBrowserData = Action.async(BodyParsers.parse.json) { request =>
//    val browserData = request.body.validate[BrowserDataSubmit]
//    browserData.fold(
//      errors => Future(validationErrorResponse),
//      browserData => {
//        ws.url("https://freegeoip.net/json/" + request.remoteAddress).get().map(
////        ws.url("https://freegeoip.net/Json/86.50.146.230").get.map( // FOR TESTING
//          response => // Prod
//            response.json.validate[GeoData]
//        ) map {
//          geoData => {
//            (request.session.get("uid"), geoData) match {
//              case (Some(uid), s: JsSuccess[GeoData]) => {
//                val gd = s.get
//
//                testService.submitBrowserData(uid, request.remoteAddress, browserData.os, browserData.osVersion, browserData.browser,
//                  browserData.browserVersion, request.headers.get("Accept-Language"), Some(gd.countryCode), Some(gd.regionCode))
//                if(gd.countryCode.isEmpty) {
//                  Ok(Json.obj("status" -> "OK")).withSession(request.session + ("geodata" -> "false"))
//                } else {
//                  Ok(Json.obj("status" -> "OK"))
//                }
//              }
//              case (Some(uid), e: JsError) => {
//                testService.submitBrowserData(uid, request.remoteAddress, browserData.os, browserData.osVersion, browserData.browser,
//                  browserData.browserVersion, request.headers.get("Accept-Language"), None, None)
//                Ok(Json.obj("status" -> "OK")).withSession(request.session + ("geodata" -> "false"))
//              }  // Prod
//              case _ => uidMissingResponse
//            }
//          }
//        }
//      }
//    )
//  }


//   TESTING
  def saveBrowserData = Action.async(BodyParsers.parse.json) { request =>
    val browserData = request.body.validate[BrowserDataSubmit]
    browserData.fold(
      errors => Future(validationErrorResponse),
      browserData => {
        request.session.get("uid") match {
          case (Some(uid)) => {
            testService.submitBrowserData(uid, request.remoteAddress, browserData.os, browserData.osVersion, browserData.browser,
              browserData.browserVersion, request.headers.get("Accept-Language"), Some("fi"), Some("fi"))
            Future(Ok(Json.obj("status" -> "OK")))
          }
          case _ => Future(uidMissingResponse)
        }
      }
    )
  }

  def questionnairePost = Action { implicit request =>
    questionnaireForm.bindFromRequest().fold(
      errors => {
        validationErrorResponse
      },
      ud => {
        request.session.get("uid") match {
          case Some(uid) => {
            testService.submitUserData(uid, ud.age, ud.gender, ud.hasTakenTypingCourse.toBoolean, ud.fingers,
                                      ud.timeSpentTyping, ud.layout, ud.keyboardType, ud.nativeLanguage, ud.country, ud.state)
            Ok(Json.obj("status" -> "OK")).withSession(request.session + ("questionnaire" -> "true"))
          }
          case None => uidMissingResponse
        }
      }
    )
  }

  implicit val keystrokeSubmitReads: Reads[KeystrokeSubmit] = (
      (JsPath \ "pressTime").read[Long] and
      (JsPath \ "releaseTime").read[Long] and
      (JsPath \ "keycode").read[Int] and
      (JsPath \ "letter").read[String]
    )(KeystrokeSubmit.apply _)

  implicit val browserDataSubmitReads: Reads[BrowserDataSubmit] = (
      (JsPath \ "os").read[String] and
      (JsPath \ "osVersion").readNullable[String] and
      (JsPath \ "browser").read[String] and
      (JsPath \ "browserVersion").readNullable[String]
    )(BrowserDataSubmit.apply _)

  implicit val geoDataReads: Reads[GeoData] = (
      (JsPath \ "country_code").read[String] and
      (JsPath \ "region_code").read[String]
    )(GeoData.apply _)
}
