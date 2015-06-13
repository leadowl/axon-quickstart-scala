name := "axon-quickstart-scala"

version := "1.0"

scalaVersion := "2.11.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= {
  val spray_version = "1.3.3"
  val scynapse_version = "0.4"

  Seq(
    "xalan" % "serializer" % "2.7.2",

    "io.spray" %% "spray-caching" % spray_version,
    "io.spray" %% "spray-can" % spray_version,
    "io.spray" %% "spray-client" % spray_version,
    "io.spray" %% "spray-http" % spray_version,
    "io.spray" %% "spray-httpx" % spray_version,
    "io.spray" %% "spray-io" % spray_version,
    "io.spray" %% "spray-servlet" % spray_version,
    "io.spray" %% "spray-routing" % spray_version,
    "io.spray" %% "spray-testkit" % spray_version,
    "io.spray" %% "spray-util" % spray_version,
    "io.spray" %% "spray-json" % "1.3.2",

    "org.axonframework.scynapse" %% "scynapse-core" % scynapse_version,
//    "org.axonframework.scynapse" %% "scynapse-akka" % scynapse_version,
    "org.axonframework.scynapse" %% "scynapse-test" % scynapse_version % "test",

    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
    "junit" % "junit" % "4.12" % "test",
    "com.novocode" % "junit-interface" % "0.11" % "test"
  )
}

testOptions in Test += Tests.Argument("-oD")

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-v")

// Revolver.settings