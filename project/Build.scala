import sbt._
import Keys._

object EulerBuild extends Build {
  import Dependencies._

  lazy val defaultSettings = Seq(
    organization := "com.geekple",
    name := "euler",
    version := "1.0",
    libraryDependencies ++= Seq(scalatest),
    scalaVersion := "2.10.1",
    scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")
  )

  lazy val root = Project("root", file("."))
    .settings(defaultSettings: _*)
}
