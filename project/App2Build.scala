import sbt._
import Keys._
import play.Project._

object App2Build extends Build {

  val appName         = "app2"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies, path=file(".") / "app2").settings(
    // Add your own project settings here      
  )

}
