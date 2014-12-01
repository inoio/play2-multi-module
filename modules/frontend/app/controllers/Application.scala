package controllers

import play.api.libs.ws.WS
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Play.current

object Application extends Controller {

  def things(count: Int, waitTime: Long = 0) = Action.async { request =>
    val host = request.headers("Host")
    val port = host.substring(host.indexOf(":") + 1).toInt
    WS.url(s"http://localhost:${port + 1}/things")
      .withQueryString("count" -> count.toString, "waitTime" -> waitTime.toString)
      .get()
      .map { resp =>
        val status = resp.status
        Status(status)(resp.body)
      }
  }

}
