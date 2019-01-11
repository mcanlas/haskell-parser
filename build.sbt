val commonSettings = Seq(organization := "com.htmlism",
                         scalaVersion := "2.12.8",
                         crossScalaVersions := Seq("2.11.12", "2.12.8"))

lazy val root = Project("haskell-parser", file("."))
  .settings(commonSettings: _*)
  .settings(withParsingLibrary)

lazy val withParsingLibrary =
  libraryDependencies += "com.lihaoyi" %% "fastparse" % "2.1.0"
