

name := "visu"

organization := "com.jayway"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.6.1",
  "org.specs2" %% "specs2-scalaz-core" % "6.0.1" % "test",
  "junit" % "junit" % "4.8.2" % "test",
  "net.kuruvila" %% "graphviz" % "1.0-SNAPSHOT"
)

resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
                    "releases"  at "http://scala-tools.org/repo-releases")

