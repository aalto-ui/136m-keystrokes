
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/samulid/src/typingmaster/conf/routes
// @DATE:Wed Jun 14 14:02:50 EEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseTypingTest(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def uidErr(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "uid_err")
    }
  
    // @LINE:6
    def typingTest(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "typingtest")
    }
  
    // @LINE:16
    def updateStats(): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "updateStats")
    }
  
    // @LINE:22
    def saveBrowserData(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "browserData")
    }
  
    // @LINE:12
    def newUid(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "newUid")
    }
  
    // @LINE:4
    def instructions(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:5
    def consent(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "consent")
    }
  
    // @LINE:14
    def getWPM(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getWPM")
    }
  
    // @LINE:7
    def questionnaire(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "questionnaire")
    }
  
    // @LINE:8
    def results(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "results")
    }
  
    // @LINE:13
    def sentence(first:Boolean): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "sentence/" + implicitly[PathBindable[Boolean]].unbind("first", first))
    }
  
    // @LINE:20
    def saveKeystrokes(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "keystrokes")
    }
  
    // @LINE:21
    def saveUserInput(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "userInput")
    }
  
    // @LINE:15
    def getErrorRate(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getErrorRate")
    }
  
    // @LINE:1
    def typingtestRoutes(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "typingtestRoutes")
    }
  
    // @LINE:23
    def questionnairePost(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "questionnaire")
    }
  
  }

  // @LINE:29
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:26
  class ReverseExternalAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("root", "/var/www/typingmaster/assets/")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/external/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }


}
