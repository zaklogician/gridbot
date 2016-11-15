
lazy val root = (project in file(".")).
  settings(
    name := "gridbot",
    version := "0.1.0",
    scalaVersion := "2.10.4",
    mainClass in Compile := Some("Genetic")
  )

// Because I'm _just_ mean
// scalacOptions += "-deprecation"

// for https://github.com/scopt/scopt
resolvers += Resolver.sonatypeRepo("public")

libraryDependencies ++= Seq(
  //groupID % artifactID % revision
  "org.scalacheck" % "scalacheck_2.10" % "1.13.4" % "test"
)