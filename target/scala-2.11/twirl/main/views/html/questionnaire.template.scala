
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object questionnaire_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class questionnaire extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[QuestionnaireData],RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(questionnaireForm: Form[QuestionnaireData])(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.79*/("""

    """),_display_(/*3.6*/main("Questionnaire")/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
        """),format.raw/*4.9*/("""<div class="container" id="questionnaire">
            <div class="row" id="separator"></div>

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <h1 class="italic" style="float: left;">Typing Speed Test - Questionnaire</h1>
                </div>
                <div class="col-lg-3"></div>
            </div>

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6" id="alert-row"></div>
            </div>

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <h4>
                        <p>We are computing your results…</p>
                        <p>While you wait, please fill out the following questions:</p>
                    </h4>
                </div>
                <div class="col-lg-3"></div>
            </div>


            <form id="questionnaire-form">
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                1. What is your age?
                            </h4>
                        </div>
                        <div>
                            <input id=""""),_display_(/*42.41*/questionnaireForm("age")/*42.65*/.id),format.raw/*42.68*/("""" class="test-field questionnaire-input" type="text">
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                2. What is your gender?
                            </h4>
                        </div>
                        <div>
                            <input id="none-rdio" class="questionnaire-input" type="radio" name="gender" value="none" checked> Prefer not to specify<br>
                            <input id="male-rdio" class="questionnaire-input" type="radio" name="gender" value="male"> Male<br>
                            <input id="female-rdio" class="questionnaire-input" type="radio" name="gender" value="female"> Female<br>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                3. Have you ever taken a typing course?
                            </h4>
                        </div>
                        <div>
                            <input id="yes-tc-rdio" class="questionnaire-input" type="radio" name="typing-course" value="true"> Yes<br>
                            <input id="no-tc-rdio" class="questionnaire-input" type="radio" name="typing-course" value="false" checked> No<br>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                4. How many fingers do you use while typing?
                            </h4>
                        </div>
                        <div>
                            <select id="fingers" class="test-field questionnaire-input">
                                <option value="1-2">1-2</option>
                                <option value="3-4">3-4</option>
                                <option value="5-6">5-6</option>
                                <option value="7-8">7-8</option>
                                <option value="9-10">9-10</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                5. On average, how many hours do you spend writing with your computer per day?
                            </h4>
                        </div>
                        <div>
                            <input id="time-spent-typing" class="test-field questionnaire-input" id="test-input" type="text" class="test-field">
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                6. Look at left side of the uppermost row of letters on your keyboard. Which are the first six letters?
                            </h4>
                        </div>
                        <div>
                            <select id="layout" class="test-field questionnaire-input">
                                <option value="qwerty">QWERTY</option>
                                <option value="qwertz">QWERTZ</option>
                                <option value="azerty">AZERTY</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                6. What kind of keyboard are you using?
                            </h4>
                        </div>
                        <div>
                            <select id="keyboard-type" class="test-field questionnaire-input">
                                <option value="laptop">Laptop</option>
                                <option value="full">Physical full size</option>
                                <option value="small">Small add-on keyboard for tablets</option>
                                <option value="on-screen">On-screen keyboard</option>
                            </select>
                        </div>
                        <div>
                            <img id="kbd-type-img" src="" style="width: 50%; margin-top: 10px;">
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                7. What is your native language?
                            </h4>
                        </div>
                        <div>
                            <select id="native-language" class="test-field questionnaire-input"></select>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <div>
                            <h4>
                                8. Which country are you from?
                            </h4>
                        </div>
                        <div>
                            <select id="countries" class="test-field questionnaire-input"></select>
                        </div>
                        <div>
                            <select id="states" class="test-field questionnaire-input"></select>
                        </div>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6">
                        <button id="results-btn" class="standard disabled secondary" type="submit">Show result</button>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
            </form>

            <div class="row" style="margin-bottom: 50px;"></div>

        </div>

        <script src=""""),_display_(/*205.23*/routes/*205.29*/.Assets.versioned("javascripts/countries.js")),format.raw/*205.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*206.23*/routes/*206.29*/.Assets.versioned("javascripts/questionnaire.js")),format.raw/*206.78*/("""" type="text/javascript"></script>
    """)))}),format.raw/*207.6*/("""
"""))
      }
    }
  }

  def render(questionnaireForm:Form[QuestionnaireData],request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(questionnaireForm)(request)

  def f:((Form[QuestionnaireData]) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (questionnaireForm) => (request) => apply(questionnaireForm)(request)

  def ref: this.type = this

}


}

/**/
object questionnaire extends questionnaire_Scope0.questionnaire
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:02:51 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/questionnaire.scala.html
                  HASH: 643640bbdec77239ff5cd524fa522246c537700c
                  MATRIX: 574->1|746->78|778->85|807->106|846->108|881->117|2283->1492|2316->1516|2340->1519|9617->8768|9633->8774|9700->8819|9785->8876|9801->8882|9872->8931|9943->8971
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|66->42|66->42|66->42|229->205|229->205|229->205|230->206|230->206|230->206|231->207
                  -- GENERATED --
              */
          