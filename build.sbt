name := "sbtplate"

version := "0.1"

scalaVersion := "2.13.6"

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

libraryDependencies +=
  "org.scalactic" %% "scalactic" % "3.2.9"

// as of 3.2.0 you can depend on a smaller subset of full ScalaTest, which can help you achieve consistent style choices among team members,
// because only the modules you add to your build will be available to the project!!!
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest-funsuite" % "3.2.9" % Test,
  "org.scalatest" %% "scalatest-funspec" % "3.2.9" % Test,
  "org.scalatest" %% "scalatest-shouldmatchers" % "3.2.9" % Test
)

// TODO: supersafe complier plugin install  (download failing)
// will flag errors in your ScalaTest (and Scalactic) code at compile time
//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.12")