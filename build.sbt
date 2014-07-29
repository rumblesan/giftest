name := "giftest"

organization := "com.rumblesan"

version := "0.1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.13" % "test"
)

initialCommands := "import com.rumblesan.giftest._"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-language:_")

fork in run := true

