package controllers

import play.api.libs.concurrent.Promise
import play.api.mvc.{Action, Controller}
import java.util.concurrent.TimeUnit._

import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

object Application extends Controller {

  def things(count: Int, waitTime: Long = 0) = Action.async {
    if(waitTime == 0) Future.successful(Ok(s"$count backend things"))
    else Promise.timeout({
      Ok(s"$count backend things")
    }, waitTime, MILLISECONDS)
  }

}
