package controllers

import play.api._
import play.api.mvc._

object App2 extends Controller {
  
  def index = Action {
    Ok("This is app 2")
  }
  
}