
name := """typingmaster"""

version := "1.1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

libraryDependencies ++= Seq(
  filters,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "1.1.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
