import play.PlayScala
import io.gatling.sbt.GatlingPlugin

name := "play2-multi"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.4"

scalacOptions += "-target:jvm-1.7"

// Common dependencies
val scalatest = "org.scalatest" %% "scalatest" % "2.2.0" % "test"
val scalatestPlusPlay = "org.scalatestplus" %% "play" % "1.2.0" % "test"
val mockito = "org.mockito" % "mockito-core" % "1.9.5" % "test"
val gatling = "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.0.1" % "test"
val test_framework = "io.gatling" % "test-framework" % "1.0" % "test"

//////////////////////////////////////////////////////
// Common Dependencies
//////////////////////////////////////////////////////
lazy val commonDependencies = Seq(
  ws,
  scalatest,
  scalatestPlusPlay,
  mockito,
  gatling,
  test_framework
)


lazy val frontend = project.in(file("modules/frontend")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= commonDependencies)

lazy val backend = project.in(file("modules/backend")).enablePlugins(PlayScala)
  .settings(libraryDependencies ++= commonDependencies)

// Execute tests with gatling:test, gatling:testOnly
// Start the recorder with gatling:startRecorder
lazy val stress_tests = project.in(file("modules/stress_tests"))
  .enablePlugins(GatlingPlugin)
  .settings(
    libraryDependencies ++= Seq(
    gatling,
    test_framework
    )
  )

lazy val main = project.in(file("."))
  .aggregate(frontend, backend, stress_tests)
  .enablePlugins(PlayScala)
