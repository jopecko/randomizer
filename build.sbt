ThisBuild / scalaVersion := "2.11.12"

ThisBuild / githubWorkflowJavaVersions := Seq("adopt@1.11")

ThisBuild / githubWorkflowOSes := Seq("macos-11.0", "macos-10.15")

ThisBuild / githubWorkflowBuild := Seq(
  WorkflowStep.Sbt(
    List("nativeLink"),
    name = Some("Link NIR and generate native binary")
  )
)

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

enablePlugins(ScalaNativePlugin)

libraryDependencies += "com.github.scopt" %%% "scopt" % "4.0.0"
