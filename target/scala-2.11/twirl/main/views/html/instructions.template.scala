
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object instructions_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class instructions extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""

"""),_display_(/*4.2*/main("Instructions")/*4.22*/ {_display_(Seq[Any](format.raw/*4.24*/("""
    """),format.raw/*5.5*/("""<div class="container" id="instructions">
        <div class="row" id="separator"></div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1 class="italic" style="float: left;">Instructions</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2 style="color: #E2333A;">Please read carefully before continuing</h2>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <ul>
                    <li>
                        You will be presented 15 sentences one by one.
                    </li>
                    <li>
                        Read each sentence carefully, <b>then</b> type it as fast and accurately as poosible.
                    </li>
                    <li>
                        Timing starts after the first keystroke and pauses between sentences. After finishing a
                        sentence, press 'Enter' to type next sentence.
                    </li>
                    <li>
                        You will get full statistics after completing 15 sentences.
                    </li>
                    <li>
                        By clicking 'Start Test' you give your <a href="consent">informed consent</a> for the data collected during the test
                        to be stored and used for research purposes.
                    </li>
                </ul>

                <div style="margin-top: 10px;">
                    <button id="start-btn" class="standard primary" type="button">Start test</button>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>

    <script src=""""),_display_(/*55.19*/routes/*55.25*/.Assets.versioned("javascripts/vendor/ua-parser.js")),format.raw/*55.77*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*56.19*/routes/*56.25*/.Assets.versioned("javascripts/instructions.js")),format.raw/*56.73*/("""" type="text/javascript"></script>
""")))}),format.raw/*57.2*/("""
"""))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(request)

  def f:((RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (request) => apply(request)

  def ref: this.type = this

}


}

/**/
object instructions extends instructions_Scope0.instructions
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:02:51 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/instructions.scala.html
                  HASH: 81a58f52d9f8f4af9fbaf83fa20217973f564ee7
                  MATRIX: 548->2|676->35|704->38|732->58|771->60|802->65|2775->2011|2790->2017|2863->2069|2943->2122|2958->2128|3027->2176|3093->2212
                  LINES: 20->2|25->2|27->4|27->4|27->4|28->5|78->55|78->55|78->55|79->56|79->56|79->56|80->57
                  -- GENERATED --
              */
          