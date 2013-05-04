import sbt._
import Keys._

object Dependencies {
  object V {
    val scalatest = "1.9.1"
  }

  val scalatest = "org.scalatest" %% "scalatest" % V.scalatest % "test"
}
