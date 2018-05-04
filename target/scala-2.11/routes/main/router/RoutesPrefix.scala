
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/samulid/src/typingmaster/conf/routes
// @DATE:Wed Jun 14 14:02:50 EEST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
