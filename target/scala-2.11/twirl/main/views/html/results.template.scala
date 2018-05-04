
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object results_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

     object results_Scope1 {
import models.TestResults

class results extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[TestResults,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(testResult: TestResults)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.60*/("""

"""),_display_(/*6.2*/main("Results")/*6.17*/ {_display_(Seq[Any](format.raw/*6.19*/("""
    """),format.raw/*7.132*/("""

    """),format.raw/*9.5*/("""<div id="fb-root"></div>

    <div class="container" id="results">
        <div class="row" id="separator"></div>
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1 class="italic"style="float: left;">Results</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1>Basic Statistics</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="res-row pull-left">
                    <div id="wpm-display" class="test-field sm results text-center">
                        WPM
                        <p id="wpm-key">(Words per minute)</p>
                        <div id="wpm" class="results-font">
                        """),_display_(/*37.26*/testResult/*37.36*/.wpm),format.raw/*37.40*/("""
                        """),format.raw/*38.25*/("""</div>
                    </div>
                    <h4 class="res-explanation">
                        Your typing speed is """),_display_(/*41.47*/testResult/*41.57*/.wpm),format.raw/*41.61*/(""" """),format.raw/*41.62*/("""words per minute
                    </h4>
                </div>
                <div class="test-field pull-right text-center" style="margin-top: 10px; padding: 5px;">
                    <h2 style="margin-top: 5px; font-size: 18px;">Help science to make typing faster:</h2>
                    <button class="standard secondary" type="button" >Take part in a typing experiment</button>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="res-row pull-left">
                    <div class="test-field sm results text-center">
                        Errors
                        <div id="error-rate" class="results-font">
                        """),_display_(/*59.26*/("%.2f%%".format(testResult.error))),format.raw/*59.61*/("""
                        """),format.raw/*60.25*/("""</div>
                    </div>
                    <h4 class="res-explanation">
                        You mistyped """),_display_(/*63.39*/("%.2f%%".format(testResult.error))),format.raw/*63.74*/(""" """),format.raw/*63.75*/("""of the characters
                    </h4>
                </div>
                <div class="pull-right text-center">
                    <h2>Share your score with friends</h2>
                    <div>
                        <button id="fb-btn" class="some-btn" type="button">
                            <img class="some-logo" src=""""),_display_(/*70.58*/routes/*70.64*/.Assets.versioned("images/logos/fb/FB-f-Logo__white_29.png")),format.raw/*70.124*/("""">
                            Share
                        </button>
                    </div>
                    <div>
                        <button id="twitter-btn" class="some-btn" type="button">
                            <img class="some-logo" src=""""),_display_(/*76.58*/routes/*76.64*/.Assets.versioned("images/logos/twitter/Twitter_Social_Icon_Square_White.png")),format.raw/*76.142*/("""">
                            Tweet
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1>Speed</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                """),_display_(/*96.18*/if(testResult.wpm > 20 && testResult.wpm < 120)/*96.65*/ {_display_(Seq[Any](format.raw/*96.67*/("""
                    """),format.raw/*97.21*/("""<div class="hist-results">
                        <img class="test-field" id="wpm-img" src=""""),_display_(/*98.68*/routes/*98.74*/.ExternalAssets.at("images/wpm/wpm_" + ((testResult.wpm - 20) / 5).toString +  ".png")),format.raw/*98.160*/("""">
                    </div>
                """)))}),format.raw/*100.18*/("""
            """),format.raw/*101.13*/("""</div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row" id="separator"></div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="res-row">
                    <div>
                        <img class="stat-icon" src=""""),_display_(/*112.54*/routes/*112.60*/.Assets.versioned("images/speedometer_icon.png")),format.raw/*112.108*/("""" width="60" height="50">
                        <h5 style="margin-left: 2px;">Typing<br/>Speed</h5>
                    </div>
                    <div class="res-explanation">
                        WPM, or words per minute, is the measure of your typing speed. In comparison, humans produce
                        spoken language at 250 wpm. <br/>
                            <a data-toggle="collapse" href="#error-explanation">
                                Click here to find out how your wpm is calculated <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                            </a>
                        <div class="collapse" id="wpm-explanation">
                            The wpm of each sentence is calculated by taking the difference in time between your first and last keystroke, and dividing that
                            by the total number of characters in the final input. This results in the average speed per keystroke. This is then multiplied by
                            five to get average speed per word. One minute is then divided with this speed to get the final wpm value. To get the final wpm
                            score a weighted (based on the length of each sentence) average of all individual sentence scores is calculated.
                        </div>
                    </div>
                    <p>

                    </p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2>Fastest sentence (errors: """),_display_(/*138.48*/(testResult.sFastestError)),format.raw/*138.74*/(""", wpm: """),_display_(/*138.82*/testResult/*138.92*/.sFastestWpm),format.raw/*138.104*/("""):</h2>
                <div class="test-field test-input results">
                """),_display_(/*140.18*/testResult/*140.28*/.sFastest),format.raw/*140.37*/("""
                """),format.raw/*141.17*/("""</div>
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2>Slowest sentence (errors: """),_display_(/*148.48*/(testResult.sSlowestError)),format.raw/*148.74*/(""", wpm: """),_display_(/*148.82*/testResult/*148.92*/.sSlowestWpm),format.raw/*148.104*/("""):</h2>
                <div class="test-field test-input results">
                """),_display_(/*150.18*/testResult/*150.28*/.sSlowest),format.raw/*150.37*/("""
                """),format.raw/*151.17*/("""</div>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1>Error</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                """),_display_(/*167.18*/if(testResult.error >= 0 && testResult.error < 5)/*167.67*/ {_display_(Seq[Any](format.raw/*167.69*/("""
                    """),format.raw/*168.21*/("""<div class="hist-results">
                        <img class="test-field" id="er_img" src=""""),_display_(/*169.67*/routes/*169.73*/.ExternalAssets.at("images/error/error_" + (testResult.error / 0.25).toInt.toString +  ".png")),format.raw/*169.167*/("""">
                    </div>
                """)))}),format.raw/*171.18*/("""
            """),format.raw/*172.13*/("""</div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row" id="separator"></div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div class="res-row">
                    <div>
                        <img class="stat-icon" src=""""),_display_(/*183.54*/routes/*183.60*/.Assets.versioned("images/X.png")),format.raw/*183.93*/("""" width="60" height="50">
                        <h5 style="margin-left: 2px;">Error<br/>Rate</h5>
                    </div>
                    <div class="res-explanation">
                        Error rate is the percentage of mistyped characters, not words. It commonly varies between 0% - 0.5%. <br />
                        <a data-toggle="collapse" href="#error-explanation">
                            Click here to find out how your error rate is calculated <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                        </a>
                        <div class="collapse" id="error-explanation">
                            <p>
                                To calculate your error rate, each sentence you inputted is compared to the correct sentence. Edit distance,
                                a value which measures differences between two strings, is then calculated with the
                                <a target="_blank" href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein distance</a> formula. A percentage of error is derived
                                by comparing the edit distance and either the correct sentence or the sentence inputted, which ever is longer. To get the final
                                error rate of the whole test, a weighted (based on sentence length) average of all error rates is calculated.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        """),_display_(/*205.10*/if(testResult.sMostErr.isDefined)/*205.43*/ {_display_(Seq[Any](format.raw/*205.45*/("""
            """),format.raw/*206.13*/("""<div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <h2>Sentence with highest error rate (errors: """),_display_(/*209.68*/(testResult.sMostErrDist)),format.raw/*209.93*/(""", wpm: """),_display_(/*209.101*/testResult/*209.111*/.sMostErrWpm),format.raw/*209.123*/("""):</h2>
                    <div class="test-field test-input results">
                        """),_display_(/*211.26*/testResult/*211.36*/.sMostErr),format.raw/*211.45*/(""" """),format.raw/*211.46*/("""("""),_display_(/*211.48*/testResult/*211.58*/.sMostErrCor),format.raw/*211.70*/(""")
                    </div>
                </div>
                <div class="col-lg-3"></div>
            </div>
        """)))}),format.raw/*216.10*/("""

        """),format.raw/*218.9*/("""<div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <hr>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div id="next-row" class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-5">
                <button id="retake-btn" class="standard secondary" type="button">Continue with 15 new sentences</button>
                <button id="restart-btn" class="standard secondary" type="button">Restart from beginning</button>
            </div>
            <div class="col-lg-4"></div>
        </div>

        <div id="last-row" class="row"></div>

    </div>

    <script src=""""),_display_(/*239.19*/routes/*239.25*/.Assets.versioned("javascripts/result.js")),format.raw/*239.67*/("""" type="text/javascript"></script>
""")))}),format.raw/*240.2*/("""
"""))
      }
    }
  }

  def render(testResult:TestResults,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(testResult)(request)

  def f:((TestResults) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (testResult) => (request) => apply(testResult)(request)

  def ref: this.type = this

}


}
}

/**/
object results extends results_Scope0.results_Scope1.results
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:02:51 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/results.scala.html
                  HASH: 07adab57eb4df9f76917ffceb76f70a20f510419
                  MATRIX: 606->30|759->88|787->91|810->106|849->108|882->240|914->246|1932->1237|1951->1247|1976->1251|2029->1276|2185->1405|2204->1415|2229->1419|2258->1420|3114->2249|3170->2284|3223->2309|3371->2430|3427->2465|3456->2466|3821->2804|3836->2810|3918->2870|4207->3132|4222->3138|4322->3216|4874->3741|4930->3788|4970->3790|5019->3811|5140->3905|5155->3911|5263->3997|5342->4044|5384->4057|5743->4388|5759->4394|5830->4442|7474->6058|7522->6084|7558->6092|7578->6102|7613->6114|7726->6199|7746->6209|7777->6218|7823->6235|8082->6466|8130->6492|8166->6500|8186->6510|8221->6522|8334->6607|8354->6617|8385->6626|8431->6643|8870->7054|8929->7103|8970->7105|9020->7126|9141->7219|9157->7225|9274->7319|9353->7366|9395->7379|9754->7710|9770->7716|9825->7749|11420->9316|11463->9349|11504->9351|11546->9364|11743->9533|11790->9558|11827->9566|11848->9576|11883->9588|12008->9685|12028->9695|12059->9704|12089->9705|12119->9707|12139->9717|12173->9729|12330->9854|12368->9864|13091->10559|13107->10565|13171->10607|13238->10643
                  LINES: 23->4|28->4|30->6|30->6|30->6|31->7|33->9|61->37|61->37|61->37|62->38|65->41|65->41|65->41|65->41|83->59|83->59|84->60|87->63|87->63|87->63|94->70|94->70|94->70|100->76|100->76|100->76|120->96|120->96|120->96|121->97|122->98|122->98|122->98|124->100|125->101|136->112|136->112|136->112|162->138|162->138|162->138|162->138|162->138|164->140|164->140|164->140|165->141|172->148|172->148|172->148|172->148|172->148|174->150|174->150|174->150|175->151|191->167|191->167|191->167|192->168|193->169|193->169|193->169|195->171|196->172|207->183|207->183|207->183|229->205|229->205|229->205|230->206|233->209|233->209|233->209|233->209|233->209|235->211|235->211|235->211|235->211|235->211|235->211|235->211|240->216|242->218|263->239|263->239|263->239|264->240
                  -- GENERATED --
              */
          