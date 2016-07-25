name := "cash-cow"
version := "0.1.0"
scalaVersion in ThisBuild := "2.11.8"

lazy val `core` = project in new File("core") settings(
  libraryDependencies ++= Seq(
    "com.chuusai" %% "shapeless" % "2.3.1",
    "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
  ))
