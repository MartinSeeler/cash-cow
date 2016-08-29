name := "cash-cow"
version := "0.1.0"
scalaVersion in ThisBuild := "2.11.8"

coverageEnabled in ThisBuild := true

lazy val `core` = project in new File("core") settings(

  libraryDependencies ++= Seq(
    "com.chuusai"     %% "shapeless"    % "2.3.1",
    "org.scalacheck"  %% "scalacheck"   % "1.13.2"  % "test",
    "org.scalatest"   %% "scalatest"    % "2.2.6"   % "test"
  ))

lazy val docs = project in new File("docs") dependsOn core settings(
//  tutsSettings(core)
)

addCommandAlias("travis", ";clean;coverage;testOnly;coverageReport;coverageAggregate")
