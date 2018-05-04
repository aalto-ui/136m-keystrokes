
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/samulid/src/typingmaster/conf/routes
// @DATE:Wed Jun 14 14:02:50 EEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:1
  class ReverseTypingTest(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def uidErr: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.uidErr",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "uid_err"})
        }
      """
    )
  
    // @LINE:6
    def typingTest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.typingTest",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "typingtest"})
        }
      """
    )
  
    // @LINE:16
    def updateStats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.updateStats",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "updateStats"})
        }
      """
    )
  
    // @LINE:22
    def saveBrowserData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.saveBrowserData",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "browserData"})
        }
      """
    )
  
    // @LINE:12
    def newUid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.newUid",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newUid"})
        }
      """
    )
  
    // @LINE:4
    def instructions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.instructions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:5
    def consent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.consent",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent"})
        }
      """
    )
  
    // @LINE:14
    def getWPM: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.getWPM",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getWPM"})
        }
      """
    )
  
    // @LINE:7
    def questionnaire: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.questionnaire",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "questionnaire"})
        }
      """
    )
  
    // @LINE:8
    def results: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.results",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results"})
        }
      """
    )
  
    // @LINE:13
    def sentence: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.sentence",
      """
        function(first0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sentence/" + (""" + implicitly[PathBindable[Boolean]].javascriptUnbind + """)("first", first0)})
        }
      """
    )
  
    // @LINE:20
    def saveKeystrokes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.saveKeystrokes",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "keystrokes"})
        }
      """
    )
  
    // @LINE:21
    def saveUserInput: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.saveUserInput",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userInput"})
        }
      """
    )
  
    // @LINE:15
    def getErrorRate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.getErrorRate",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getErrorRate"})
        }
      """
    )
  
    // @LINE:1
    def typingtestRoutes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.typingtestRoutes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "typingtestRoutes"})
        }
      """
    )
  
    // @LINE:23
    def questionnairePost: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TypingTest.questionnairePost",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "questionnaire"})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseExternalAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ExternalAssets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/external/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
