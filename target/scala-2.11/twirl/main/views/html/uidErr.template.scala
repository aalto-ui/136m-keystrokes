
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object uidErr_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class uidErr extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""

"""),_display_(/*3.2*/main("Instructions")/*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""
    """),format.raw/*4.5*/("""<div class="container" id="instructions">
        <div class="row" id="separator"></div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h1 class="italic" style="float: left;">Error</h1>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2 style="color: #E2333A;">Your browser appears to be unsupported.</h2>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <p>
                    To be able to use this test, we need to be able to set a cookie on your browser. This cookie won't be used
                    for tracking your personal information, its purpose is to make sure we show the correct results to you at
                    the end of the test. Some browsers have more strict default settings regarding cookies, which generally
                    is a good thing. Unfortunately, in this case it also means our test won't work as it's supposed to work.
                </p>
                <p>
                    You have a few options to make the test work correctly. You can use Google Chrome, which is supported
                    out-of-the-box, or you can change your security settings to allow the test to work as it's supposed to.
                    Remember to change the settings back as they were after completing the test!
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2>
                    Instructions for changing the settings in Firefox:
                </h2>
                <ul>
                    <li>
                        Click the menu button on the upper right corner of your browser window.
                    </li>
                    <li>
                        Select Preferences.
                    </li>
                    <li>
                        From the list on the left side of the page, click Privacy.
                    </li>
                    <li>
                        Under History, select "Use custom settings for history" from the dropdown menu.
                    </li>
                    <li>
                        New options should appear. Select "Always" from the "Accept third-party cookies" dropdown menu.
                    </li>
                    <li>
                        Close preferences tab and reload the page.
                    </li>
                </ul>
            </div>
            <div class="col-lg-3"></div>
        </div>

        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <h2>
                    Instructions for changing the settings in Safari on macOS:
                </h2>
                <ul>
                    <li>
                        Click Safari on your menu bar.
                    </li>
                    <li>
                        Select Preferences.
                    </li>
                    <li>
                        Open privacy setting by selecting the Privacy tab.
                    </li>
                    <li>
                        Select "Always allow" under the "Cookies and website data" setting.
                    </li>
                    <li>
                        Close preferences tab and reload the page.
                    </li>
                </ul>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(request)

  def f:((RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (request) => apply(request)

  def ref: this.type = this

}


}

/**/
object uidErr extends uidErr_Scope0.uidErr
              /*
                  -- GENERATED --
                  DATE: Wed Jun 14 14:32:33 EEST 2017
                  SOURCE: /home/samulid/src/typingmaster/app/views/uidErr.scala.html
                  HASH: 53254f5c6b49ee98c411b2f425f3e449b0ee0363
                  MATRIX: 536->1|664->34|692->37|720->57|759->59|790->64
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4
                  -- GENERATED --
              */
          