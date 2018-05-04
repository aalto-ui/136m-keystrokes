package controllers

import java.io.File
import javax.inject.Singleton

import play.api._
import play.api.mvc.{Action, Controller}


@Singleton
class ExternalAssets extends Controller {

  def at(root: String, file: String) = Action {
    val img: File = new File(root + file)
    if (img.exists()) {
      Ok.sendFile(img)
    } else {
      NotFound
    }
  }

}
