
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object consent_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class consent extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.35*/("""

"""),_display_(/*4.2*/main("Informed Consent")/*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
    """),format.raw/*5.5*/("""<div class="container" id="instructions">

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1 class="italic" style="float: left;">Informed Consent</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <p>
                    <b>Collection of data:</b> The data collected consists of: 1) Keypress times and their associated letters;
                    2) Demographical data and data about participants’ previous writing experience for statistical purposes.
                </p>
                <p>
                    <b>Anonymity, secure storage, confidentiality:</b> The data will be used for scientific purposes only and
                    are confidential. All data will be anonymized. No explicit clues of your identity will be left
                    to the stored data. All data will be stored securely.
                </p>
                <p>
                    <b>Suitability for the study:</b> Legally competent adults are allowed as participants.
                </p>
                <p>
                    <b>Voluntary participation:</b> Participation in the study is voluntary. You have the right to discontinue
                    participation at any time without obligation to disclose any specific reasons.
                </p>
                <p>
                    <b>Research group's experience of the method:</b> The members of the group have experience in over 50+
                    controlled studies in human-computer interaction. There are no reported incidents of ethical misconduct.
                </p>
                <p>
                    <i>We thank you for your contribution to research efforts.</i>
                </p>

                <div style="margin-top: 10px;">
                    <button id="back-btn" class="standard secondary" type="button">Back to Instructions</button>
                </div>

                <h2>Funding information and contact</h2>
                <p>
                    This study is funded by the European Research Council under the Horizon
                    2020 program (ERC Starting Grant contract ID 637991).
                </p>
                <p class="text-mono-sm">
                    MSc. Anna Feit<br />
                    Aalto University<br />
                    anna.feit@aalto.fi<br />
                </p>
                <p class="text-mono-sm">
                    Prof. Antti Oulasvirta<br />
                    Aalto University<br />
                    antti.oulasvirta@gmail.com<br />
                </p>
                <p class="text-mono-sm">
                    Prof. Per Ola Kristensson<br />
                    University of Cambridge<br />
                    kristensson@acm.org<br />
                </p>


            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>

    <script src=""""),_display_(/*73.19*/routes/*73.25*/.Assets.versioned("javascripts/consent.js")),format.raw/*73.68*/("""" type="text/javascript"></script>
""")))}),format.raw/*74.2*/("""
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
object consent extends consent_Scope0.consent
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:02:51 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/consent.scala.html
                  HASH: 21d9f97419c612c7055200d79f2ac6d537bb15e0
                  MATRIX: 538->2|666->35|694->38|726->62|765->64|796->69|3867->3116|3882->3122|3946->3165|4012->3201
                  LINES: 20->2|25->2|27->4|27->4|27->4|28->5|96->73|96->73|96->73|97->74
                  -- GENERATED --
              */
          