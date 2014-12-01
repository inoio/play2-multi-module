package controllers

import play.api.mvc.{Action, Controller}

object Application extends Controller {

  def things(count: Int) = Action {
    Ok(s"$count things")
  }

}
