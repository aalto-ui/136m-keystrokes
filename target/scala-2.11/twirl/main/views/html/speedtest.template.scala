
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object speedtest_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class speedtest extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""

"""),_display_(/*4.2*/main("Typing test")/*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""

  """),format.raw/*6.3*/("""<div class="container" id="typingtest">
    <div class="row" id="separator"></div>
    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">
        <h1 style="float: left;">Typing Speed Test</h1>

        <div class="test-field results sm right text-center">
          Phrase
          <div id="sentence-count" class="results-font">
            Loading...
          </div>
        </div>

      </div>
      <div class="col-md-3"></div>
    </div>

    <div id="sentence-row" class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">
        <h2>Read through the sentence, then type is out as fast and as accurately as you can.</h2>
        <input id="test-sentence" type="text" class="test-field test-input sentence" disabled="disabled">
      </div>
      <div class="col-md-3"></div>
    </div>

    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">
        <input id="test-input" type="text" class="test-field test-input sentence">
      </div>
      <div class="col-md-3"></div>
    </div>

    <div id="next-row" class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">

        <button id="next-btn" class="standard secondary" type="button">Next [Enter]</button>

      </div>
      <div class="col-md-3"></div>
    </div>

    <div id="next-row" class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">

        <h2 id="avg-res-text" class="right">Results (average):</h2>

      </div>
      <div class="col-md-3"></div>
    </div>

    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-6">

        <div id="wpm-display" class="test-field sm right text-center">
          WPM
          <p id="wpm-key">(Words per minute)</p>
          <div id="wpm" class="results-font">
            0
          </div>
        </div>

        <div class="test-field sm right text-center">
          Errors
          <div id="error-rate" class="results-font">
            0%
          </div>
        </div>

      </div>
      <div class="col-md-3"></div>
    </div>

  </div>

  <script src=""""),_display_(/*86.17*/routes/*86.23*/.Assets.versioned("javascripts/speedtest.js")),format.raw/*86.68*/("""" type="text/javascript"></script>
""")))}),format.raw/*87.2*/("""
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
object speedtest extends speedtest_Scope0.speedtest
              /*
                  -- GENERATED --
                  DATE: Mon Jun 19 11:28:39 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/speedtest.scala.html
                  HASH: a61dc17b3ccbf4bfa09b77abc19593a1688d161b
                  MATRIX: 542->2|670->35|698->38|725->57|764->59|794->63|2954->2196|2969->2202|3035->2247|3101->2283
                  LINES: 20->2|25->2|27->4|27->4|27->4|29->6|109->86|109->86|109->86|110->87
                  -- GENERATED --
              */
          