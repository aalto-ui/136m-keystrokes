
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/samulid/src/typingmaster/conf/routes
// @DATE:Wed Jun 14 14:02:50 EEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  TypingTest_0: controllers.TypingTest,
  // @LINE:26
  ExternalAssets_2: controllers.ExternalAssets,
  // @LINE:29
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    TypingTest_0: controllers.TypingTest,
    // @LINE:26
    ExternalAssets_2: controllers.ExternalAssets,
    // @LINE:29
    Assets_1: controllers.Assets
  ) = this(errorHandler, TypingTest_0, ExternalAssets_2, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TypingTest_0, ExternalAssets_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """typingtestRoutes""", """controllers.TypingTest.typingtestRoutes"""),
    ("""GET""", this.prefix, """controllers.TypingTest.instructions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """consent""", """controllers.TypingTest.consent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """typingtest""", """controllers.TypingTest.typingTest"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questionnaire""", """controllers.TypingTest.questionnaire"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """results""", """controllers.TypingTest.results"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """uid_err""", """controllers.TypingTest.uidErr"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """newUid""", """controllers.TypingTest.newUid"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sentence/""" + "$" + """first<[^/]+>""", """controllers.TypingTest.sentence(first:Boolean)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getWPM""", """controllers.TypingTest.getWPM"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getErrorRate""", """controllers.TypingTest.getErrorRate"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateStats""", """controllers.TypingTest.updateStats"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """keystrokes""", """controllers.TypingTest.saveKeystrokes"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userInput""", """controllers.TypingTest.saveUserInput"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """browserData""", """controllers.TypingTest.saveBrowserData"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """questionnaire""", """controllers.TypingTest.questionnairePost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/external/""" + "$" + """file<.+>""", """controllers.ExternalAssets.at(root:String = "/var/www/typingmaster/assets/", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_TypingTest_typingtestRoutes0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("typingtestRoutes")))
  )
  private[this] lazy val controllers_TypingTest_typingtestRoutes0_invoker = createInvoker(
    TypingTest_0.typingtestRoutes,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "typingtestRoutes",
      Nil,
      "GET",
      """""",
      this.prefix + """typingtestRoutes"""
    )
  )

  // @LINE:4
  private[this] lazy val controllers_TypingTest_instructions1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TypingTest_instructions1_invoker = createInvoker(
    TypingTest_0.instructions,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "instructions",
      Nil,
      "GET",
      """ Actual HTML-pages""",
      this.prefix + """"""
    )
  )

  // @LINE:5
  private[this] lazy val controllers_TypingTest_consent2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("consent")))
  )
  private[this] lazy val controllers_TypingTest_consent2_invoker = createInvoker(
    TypingTest_0.consent,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "consent",
      Nil,
      "GET",
      """""",
      this.prefix + """consent"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_TypingTest_typingTest3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("typingtest")))
  )
  private[this] lazy val controllers_TypingTest_typingTest3_invoker = createInvoker(
    TypingTest_0.typingTest,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "typingTest",
      Nil,
      "GET",
      """""",
      this.prefix + """typingtest"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_TypingTest_questionnaire4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questionnaire")))
  )
  private[this] lazy val controllers_TypingTest_questionnaire4_invoker = createInvoker(
    TypingTest_0.questionnaire,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "questionnaire",
      Nil,
      "GET",
      """""",
      this.prefix + """questionnaire"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_TypingTest_results5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("results")))
  )
  private[this] lazy val controllers_TypingTest_results5_invoker = createInvoker(
    TypingTest_0.results,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "results",
      Nil,
      "GET",
      """""",
      this.prefix + """results"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_TypingTest_uidErr6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("uid_err")))
  )
  private[this] lazy val controllers_TypingTest_uidErr6_invoker = createInvoker(
    TypingTest_0.uidErr,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "uidErr",
      Nil,
      "GET",
      """""",
      this.prefix + """uid_err"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TypingTest_newUid7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("newUid")))
  )
  private[this] lazy val controllers_TypingTest_newUid7_invoker = createInvoker(
    TypingTest_0.newUid,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "newUid",
      Nil,
      "GET",
      """ Routes for javascript routing""",
      this.prefix + """newUid"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_TypingTest_sentence8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sentence/"), DynamicPart("first", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TypingTest_sentence8_invoker = createInvoker(
    TypingTest_0.sentence(fakeValue[Boolean]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "sentence",
      Seq(classOf[Boolean]),
      "GET",
      """""",
      this.prefix + """sentence/""" + "$" + """first<[^/]+>"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_TypingTest_getWPM9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getWPM")))
  )
  private[this] lazy val controllers_TypingTest_getWPM9_invoker = createInvoker(
    TypingTest_0.getWPM,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "getWPM",
      Nil,
      "GET",
      """""",
      this.prefix + """getWPM"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_TypingTest_getErrorRate10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getErrorRate")))
  )
  private[this] lazy val controllers_TypingTest_getErrorRate10_invoker = createInvoker(
    TypingTest_0.getErrorRate,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "getErrorRate",
      Nil,
      "GET",
      """""",
      this.prefix + """getErrorRate"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TypingTest_updateStats11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateStats")))
  )
  private[this] lazy val controllers_TypingTest_updateStats11_invoker = createInvoker(
    TypingTest_0.updateStats,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "updateStats",
      Nil,
      "PUT",
      """""",
      this.prefix + """updateStats"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_TypingTest_saveKeystrokes12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("keystrokes")))
  )
  private[this] lazy val controllers_TypingTest_saveKeystrokes12_invoker = createInvoker(
    TypingTest_0.saveKeystrokes,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "saveKeystrokes",
      Nil,
      "POST",
      """ Routes for POST-requests
 POST    /keystrokes                 controllers.TypingTest.saveKeystroke""",
      this.prefix + """keystrokes"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_TypingTest_saveUserInput13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userInput")))
  )
  private[this] lazy val controllers_TypingTest_saveUserInput13_invoker = createInvoker(
    TypingTest_0.saveUserInput,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "saveUserInput",
      Nil,
      "POST",
      """""",
      this.prefix + """userInput"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TypingTest_saveBrowserData14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("browserData")))
  )
  private[this] lazy val controllers_TypingTest_saveBrowserData14_invoker = createInvoker(
    TypingTest_0.saveBrowserData,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "saveBrowserData",
      Nil,
      "POST",
      """""",
      this.prefix + """browserData"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_TypingTest_questionnairePost15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("questionnaire")))
  )
  private[this] lazy val controllers_TypingTest_questionnairePost15_invoker = createInvoker(
    TypingTest_0.questionnairePost,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TypingTest",
      "questionnairePost",
      Nil,
      "POST",
      """""",
      this.prefix + """questionnaire"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ExternalAssets_at16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/external/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_ExternalAssets_at16_invoker = createInvoker(
    ExternalAssets_2.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ExternalAssets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ External assets""",
      this.prefix + """assets/external/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Assets_versioned17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned17_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_TypingTest_typingtestRoutes0_route(params) =>
      call { 
        controllers_TypingTest_typingtestRoutes0_invoker.call(TypingTest_0.typingtestRoutes)
      }
  
    // @LINE:4
    case controllers_TypingTest_instructions1_route(params) =>
      call { 
        controllers_TypingTest_instructions1_invoker.call(TypingTest_0.instructions)
      }
  
    // @LINE:5
    case controllers_TypingTest_consent2_route(params) =>
      call { 
        controllers_TypingTest_consent2_invoker.call(TypingTest_0.consent)
      }
  
    // @LINE:6
    case controllers_TypingTest_typingTest3_route(params) =>
      call { 
        controllers_TypingTest_typingTest3_invoker.call(TypingTest_0.typingTest)
      }
  
    // @LINE:7
    case controllers_TypingTest_questionnaire4_route(params) =>
      call { 
        controllers_TypingTest_questionnaire4_invoker.call(TypingTest_0.questionnaire)
      }
  
    // @LINE:8
    case controllers_TypingTest_results5_route(params) =>
      call { 
        controllers_TypingTest_results5_invoker.call(TypingTest_0.results)
      }
  
    // @LINE:9
    case controllers_TypingTest_uidErr6_route(params) =>
      call { 
        controllers_TypingTest_uidErr6_invoker.call(TypingTest_0.uidErr)
      }
  
    // @LINE:12
    case controllers_TypingTest_newUid7_route(params) =>
      call { 
        controllers_TypingTest_newUid7_invoker.call(TypingTest_0.newUid)
      }
  
    // @LINE:13
    case controllers_TypingTest_sentence8_route(params) =>
      call(params.fromPath[Boolean]("first", None)) { (first) =>
        controllers_TypingTest_sentence8_invoker.call(TypingTest_0.sentence(first))
      }
  
    // @LINE:14
    case controllers_TypingTest_getWPM9_route(params) =>
      call { 
        controllers_TypingTest_getWPM9_invoker.call(TypingTest_0.getWPM)
      }
  
    // @LINE:15
    case controllers_TypingTest_getErrorRate10_route(params) =>
      call { 
        controllers_TypingTest_getErrorRate10_invoker.call(TypingTest_0.getErrorRate)
      }
  
    // @LINE:16
    case controllers_TypingTest_updateStats11_route(params) =>
      call { 
        controllers_TypingTest_updateStats11_invoker.call(TypingTest_0.updateStats)
      }
  
    // @LINE:20
    case controllers_TypingTest_saveKeystrokes12_route(params) =>
      call { 
        controllers_TypingTest_saveKeystrokes12_invoker.call(TypingTest_0.saveKeystrokes)
      }
  
    // @LINE:21
    case controllers_TypingTest_saveUserInput13_route(params) =>
      call { 
        controllers_TypingTest_saveUserInput13_invoker.call(TypingTest_0.saveUserInput)
      }
  
    // @LINE:22
    case controllers_TypingTest_saveBrowserData14_route(params) =>
      call { 
        controllers_TypingTest_saveBrowserData14_invoker.call(TypingTest_0.saveBrowserData)
      }
  
    // @LINE:23
    case controllers_TypingTest_questionnairePost15_route(params) =>
      call { 
        controllers_TypingTest_questionnairePost15_invoker.call(TypingTest_0.questionnairePost)
      }
  
    // @LINE:26
    case controllers_ExternalAssets_at16_route(params) =>
      call(Param[String]("root", Right("/var/www/typingmaster/assets/")), params.fromPath[String]("file", None)) { (root, file) =>
        controllers_ExternalAssets_at16_invoker.call(ExternalAssets_2.at(root, file))
      }
  
    // @LINE:29
    case controllers_Assets_versioned17_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned17_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
