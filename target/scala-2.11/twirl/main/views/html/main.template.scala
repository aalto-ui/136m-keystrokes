
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*7.55*/routes/*7.61*/.Assets.versioned("stylesheets/vendor/bootstrap.css")),format.raw/*7.114*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*8.55*/routes/*8.61*/.Assets.versioned("stylesheets/vendor/bootstrap-theme.css")),format.raw/*8.120*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.versioned("stylesheets/style.css")),format.raw/*9.103*/("""">

        <script src=""""),_display_(/*11.23*/routes/*11.29*/.Assets.versioned("javascripts/vendor/jquery-2.2.3.js")),format.raw/*11.84*/("""" type="text/javascript"></script>

        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("javascripts/vendor/bootstrap.js")),format.raw/*13.81*/(""""></script>

        <script src=""""),_display_(/*15.23*/routes/*15.29*/.TypingTest.typingtestRoutes),format.raw/*15.57*/("""" type="text/javascript"></script>


    </head>
    <body>
        """),_display_(/*20.10*/content),format.raw/*20.17*/("""
    """),format.raw/*21.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:02:51 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/main.scala.html
                  HASH: 1730492091c3d7d3ba1d720a064498041bda9a36
                  MATRIX: 530->1|655->31|683->33|769->93|794->98|883->161|897->167|971->220|1054->277|1068->283|1148->342|1231->399|1245->405|1308->447|1361->473|1376->479|1452->534|1537->592|1552->598|1625->650|1687->685|1702->691|1751->719|1847->788|1875->795|1907->800
                  LINES: 20->1|25->1|27->3|30->6|30->6|31->7|31->7|31->7|32->8|32->8|32->8|33->9|33->9|33->9|35->11|35->11|35->11|37->13|37->13|37->13|39->15|39->15|39->15|44->20|44->20|45->21
                  -- GENERATED --
              */
          