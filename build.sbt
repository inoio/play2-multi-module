import play.PlayScala

name := "play2-multi"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.4"

scalacOptions += "-target:jvm-1.7"

// Common dependencies
val scalatest = "org.scalatest" %% "scalatest" % "2.2.0" % "test"
val scalatestPlusPlay = "org.scalatestplus" %% "play" % "1.2.0" % "test"
val mockito = "org.mockito" % "mockito-core" % "1.9.5" % "test"

//////////////////////////////////////////////////////
// Common Dependencies
//////////////////////////////////////////////////////
lazy val commonDependencies = Seq(
  ws,
  scalatest,
  scalatestPlusPlay,
  mockito
)

lazy val frontend = project.in(file("modules/frontend")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= commonDependencies)

lazy val backend = project.in(file("modules/backend")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= commonDependencies)

lazy val main = project.in(file("."))
  .aggregate(frontend, backend)
  .enablePlugins(PlayScala)