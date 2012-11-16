This project demonstrates an inability for the `idea` command in the Play2.1 console to generate a successfully building project composed of two applications, app1 and app2, where both contain routes and the first depends on the second (using it like a submodule).

Find the following in this project:

```
/project # The builds for App1 and App2. Note how App1Build.main dependsOn App2Build.main
   App1Build.scala, App2Build.scala # Builds for the two projects   

/app1 # The main app
   /conf/routes # main application routes file. Note how it imports app2/conf/app2.routes

/app2 # The dependent app
   /conf/app2.routes # routes made for importing by another project

```

To reproduce the issue:

 * `> git clone git@github.com:eboto/play21-submodules-idea-bug.git`
 * `> cd play21-submodules-idea-bug`
 * `> play idea`
 * Edit `.idea/libraries/scala_2_10_RC1.xml`, copy-paste the line for `scala-compiler.jar`, replacing `scala-compiler.jar` with `scala-reflect.jar` 
 * `> play "project app1" "run"`
   * This generates the routes for app1 (`Routes`). If you were to open up the idea project and compile, it would work at this moment.
 * `> curl localhost:9000`
   * This generates the routes files for app2 (`app2.Routes`). If  you were to open up the idea project and compile, it would fail at this moment with the following error in app2: `error: routes is already defined as object routes`
 * Verify that the application and its submodule are correctly serving requests by navigating to `localhost:9000/` and `localhost:9000/app2`. This is only an issue in the idea project.

 I really have no idea how to fix this. It seems reasonable that IDEA can not resolve the two `routes` objects from app1 and app2 and I have no idea how sbt doesn't seem to have the same problem with this application / submodule relationship.