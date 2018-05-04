package services

import javax.inject._

import controllers.KeystrokeSubmit
import db.TestSections
import models.{Keystroke, Participant, TestSection}

import scala.Tuple2
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.math.min

trait TypingTestService {
  def newUid(): Future[String]
  def newSentence(uid: String): Future[Map[String, String]]

  def getSentence(tsId: String): Future[Map[String, String]]
  def getWPM(participantId: String): Future[Double]
  def getErrorRate(participantId: String): Future[Double]

  def getBiggestError(uid: String): Future[(Option[String], Option[String], Option[Int], Option[Int])]
  def getFastestSentence(uid: String): Future[(Option[String], Option[Int], Option[Int])]
  def getSlowestSentence(uid: String): Future[(Option[String], Option[Int], Option[Int])]

  def updateUserStats(uid: String)

  def submitKeystroke(pressTime: Long, releaseTime: Long, keycode: Int, letter: String, testSection: String)
  def submitKeystrokes(testSection: String, keystrokeSubmit: Seq[KeystrokeSubmit]): Future[Unit]
  def submitUserInput(tsId: String, userInput: String): Future[Unit]
  def submitBrowserData(uid: String, ipAddress: String, os: String, osVersion: Option[String], browser: String,
                        browserVersion: Option[String], browserLanguage: Option[String], country: Option[String], region: Option[String])
  def submitUserData(uid: String, age: Int, gender: String, hasTakenTypingCourse: Boolean, fingers: String,
                     timeSpentTyping: Int, layout: String, keyboardType: String, nativeLanguage: String, country: String, region: String)

}

@Singleton
class TypingTestServiceImpl @Inject() (databaseService: DatabaseService, cryptoService: CryptoService) extends TypingTestService {

  def newUid(): Future[String] = {
    for {
      id <- databaseService.addParticipant(Participant())
      encryptedId <- cryptoService.encrypt(id.toString)
    } yield encryptedId
  }

  def newSentence(uid: String): Future[Map[String, String]] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      s <- databaseService.getRandomSentence(decryptedUid.toInt)
      tsId <- databaseService.addTestSection(TestSection(0, s(0).id, decryptedUid.toInt))
      encryptedTsId <-cryptoService.encrypt(tsId.toString)
    } yield Map("id" -> encryptedTsId, "sentence" -> s(0).sentence)
  }

  def getSentence(tsId: String): Future[Map[String, String]] = {
    for {
      decryptedTsId <- cryptoService.decrypt(tsId)
      (s) <- databaseService.getSentence(decryptedTsId.toInt)
    } yield Map("sentence" -> s(0).sentence)
  }

//  def getWPM(uid: String): Future[Int] = {
//    for {
//      decryptedUid <- cryptoService.decrypt(uid)
//      ts <- databaseService.getTestSections(decryptedUid.toInt)
//    } yield {
//      if (ts.nonEmpty) {
//        val avg = ts.foldLeft(0)((time: Int, section) => {
//          (time + (section.inputTime.get / section.userInput.get.length)).toInt
//        }) / ts.length
//        60000 / (avg * 5)
//      } else {
//        0
//      }
//    }
//  }

//  def getWPM(uid: String): Future[Int] = {
//    for {
//      // Decrypt user id
//      decryptedUid <- cryptoService.decrypt(uid)
//      // Get test section data from db
//      ts <- databaseService.getTestSections(decryptedUid.toInt)
//    } yield {
//      if (ts.nonEmpty) {
//        // Calculate the total length of user input
//        val totalLength = ts.foldLeft(0)((tot: Int, section) => tot + section.userInput.get.length)
//        // Calculate the average speed per letter in millis. inputTime is the total input time of a sentence in millis,
//        // calculated as timestamp of last keyup event - timestamp of first keydown event
//        val avg = ts.foldLeft(0)((time: Int, section) => (time + section.inputTime.get).toInt).toDouble / totalLength
//        // Calculate the final speed in wpm
//        (60000 / (avg * 5)).toInt
//      } else {
//        // If list of test sections is empty (i.e. before the first sentence) return 0
//        0
//      }
//    }
//  }


  def getTsWPMAndLength(ts: TestSection): (Double, Int) = {
    (42.5, 10)
  }

  def getWPMTest(uid: String): Future[Double] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      ts <- databaseService.getTestSections(decryptedUid.toInt)
    } yield {
      if (ts.nonEmpty) {
        var totalLength = 0
        val avg = ts.foldLeft(0.0)((wpm: Double, section) => {
          val (tsWpm, len) = getTsWPMAndLength(section)
          totalLength += len
          wpm + tsWpm
        }) / totalLength
        60000 / (avg * 5)
      } else {
        0
      }
    }
  }

  def getWPM(uid: String): Future[Double] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      ts <- databaseService.getTestSections(decryptedUid.toInt)
    } yield {
      if (ts.nonEmpty) {
        val totalLength = ts.foldLeft(0)((tot: Int, section) => tot + section.inputLength.get)
        val avg = ts.foldLeft(0)((time: Int, section) => (time + section.inputTime.get).toInt).toDouble / totalLength
        60000 / (avg * 5)
      } else {
        0
      }
    }
  }

  def getErrorRate(uid: String): Future[Double] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      ts <- databaseService.getTestSections(decryptedUid.toInt)
    } yield {
      if (ts.nonEmpty) {
        val totalLength = ts.foldLeft(0)((tot: Int, section) => tot + section.errorLen.get)
        ts.foldLeft(0.0)((errorRate: Double, section) => errorRate + (section.errorRate.get * section.errorLen.get)) / totalLength
      } else {
        0
      }
    }
  }

  def getBiggestError(uid: String): Future[(Option[String], Option[String], Option[Int], Option[Int])] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      worst <- databaseService.getBiggestError(decryptedUid.toInt)
    }
      yield {
        if (worst.head._3.get == 0) {
          (None, None, None, None)
        } else {
          val w = worst.head
          (w._1, Some(w._2), w._3, w._4.map(_.toInt))
        }
      }
  }

  def getFastestSentence(uid: String): Future[(Option[String], Option[Int], Option[Int])] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      fastest <- databaseService.getFastestSentence(decryptedUid.toInt)
    }
    yield {
      val head = fastest.head
      (head._1, head._2, head._3.map(_.toInt))
    }
  }

  def getSlowestSentence(uid: String): Future[(Option[String], Option[Int], Option[Int])] = {
    for {
      decryptedUid <- cryptoService.decrypt(uid)
      slowest <- databaseService.getSlowestSentence(decryptedUid.toInt)
    }
      yield {
        val head = slowest.head
        (head._1, head._2, head._3.map(_.toInt))
      }
  }

  def submitKeystroke(pressTime: Long, releaseTime: Long, keycode: Int, letter: String, testSection: String) = {
    cryptoService.decrypt(testSection).foreach(id => databaseService.addKeystroke(Keystroke(0, pressTime, releaseTime, keycode, letter, id.toInt)))
  }

  def submitKeystrokes(testSection: String, keystrokeSubmit: Seq[KeystrokeSubmit]): Future[Unit] = {
    val p = Promise[Unit]()
    Future {
      val keystrokesF = for {
        kss <- keystrokeSubmit
      } yield for {
        dTsId <- cryptoService.decrypt(testSection)
      } yield {
        Keystroke(0, kss.pressTime, kss.releaseTime, kss.keycode, kss.letter, dTsId.toInt)
      }
      val keystrokes = Future.sequence(keystrokesF)
      keystrokes.foreach(ks => {
        databaseService.addKeystrokes(ks).onSuccess{
          case success => {
            p.success((): Unit)
          }
        }
      })
    }
    p.future
  }

  def submitUserInput(tsId: String, userInput: String): Future[Unit] = {
    val p = Promise[Unit]()
    Future {
      for {
        dTsId <- cryptoService.decrypt(tsId)
        tsIdInt <- databaseService.updateUserInput(dTsId.toInt, userInput)
        keystrokes <- databaseService.getKeystrokes(dTsId.toInt)
        firstKs <- databaseService.getFirstKeystroke(dTsId.toInt)
        errorData <- databaseService.getDataForError(dTsId.toInt)
      } yield {

        val inputTime = keystrokes.last.releaseTime - keystrokes.head.pressTime
        val inputLength = if (firstKs.head.letter.length > 1) userInput.length else userInput.length - 1
        val wpm = 60000.0 / ((inputTime.toDouble / inputLength) * 5.0)

        // Calculate potential avg time between keystrokes. Indexes of the tuple foldLeft takes as parametre:
        // _1: Previous keystroke (when traversing, n-1)
        // _2: Sum of time between keystrokes, calculated as sum of ks[n].down - ks[n-1].up
        // _3: Sum of total keystrokes, without backspaces
        val (_, potentialSum, potentialLen) = keystrokes.tail.foldLeft((keystrokes.head, 0, 0))((tuple, ks) =>
          if (tuple._1.letter == "BKSP") (tuple._1, tuple._2, tuple._3)
          else (ks, tuple._2 + (ks.pressTime - tuple._1.releaseTime).toInt, tuple._3 + 1)
        )

        val potentialWpm = 60000.0 / ((potentialSum.toDouble / potentialLen.toDouble) * 5.0)

        databaseService.updateInputTime(dTsId.toInt, inputTime, wpm, inputLength, potentialWpm, potentialLen) onSuccess {
          case success => {
            val ed = editDist(errorData(0)._1.get, errorData(0)._2)
            val maxLen = math.max(errorData(0)._1.get.length, errorData(0)._2.length)
            val er = (ed.toDouble / maxLen.toDouble) * (100).toDouble
            databaseService.updateErrorRate(dTsId.toInt, ed, er, maxLen) onSuccess {
              case success => p.success((): Unit)
            }
          }
        }
      }
    }
    p.future
  }

  def updateUserStats(uid: String) = {
    for {
      dUid <- cryptoService.decrypt(uid)
      er <- getErrorRate(uid)
      wpm <- getWPM(uid)
    } yield {
      databaseService.updateUserStats(dUid.toInt, wpm, er)
    }
  }

  def submitBrowserData(uid: String, ipAddress: String, os: String, osVersion: Option[String], browser: String, browserVersion: Option[String], browserLanguage: Option[String], country: Option[String], region: Option[String]) = {
    cryptoService.decrypt(uid).foreach(participantId => databaseService.updateBrowserData(participantId.toInt, ipAddress, os, osVersion, browser, browserVersion, browserLanguage, country, region))
  }

  def submitUserData(uid: String, age: Int, gender: String, hasTakenTypingCourse: Boolean, fingers: String,
                     timeSpentTyping: Int, layout: String, keyboardType: String, nativeLanguage: String, country: String, region: String) = {
    cryptoService.decrypt(uid).foreach(participantId => databaseService.updatePersonalData(participantId.toInt, age, gender, hasTakenTypingCourse, fingers, timeSpentTyping,
                                                                                            layout, keyboardType, nativeLanguage, country, region))
  }

  def editDist[A](a: Iterable[A], b: Iterable[A]): Int =
    ((0 to b.size).toList /: a)((prev, x) =>
      (prev zip prev.tail zip b).scanLeft(prev.head + 1) {
        case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
      }) last
}

