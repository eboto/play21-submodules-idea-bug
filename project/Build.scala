import sbt._
import Keys._
import play.Project._

object App1Build extends Build {

  val appName         = "app1"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies, path=file(".") / "app1").settings(
    // Add your own project settings here      
  ).dependsOn(App2Build.main)

}
