lazy val scalaJsMomentJs = project.in(file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(jsEnv := NodeJSEnv().value)

name := "Scala.js façade for Moment.js"

normalizedName := "scala-js-momentjs"

version := "0.4.1"

organization := "ru.pavkin"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.0")

val MomentVersion = "2.16.0"
val MomentTimezoneVersion = "0.5.9"

libraryDependencies ++= Seq(
  "org.webjars.bower" % "moment" % MomentVersion,
  "org.webjars.bower" % "moment-timezone" % MomentTimezoneVersion)

jsDependencies ++= Seq(
  "org.webjars.bower" % "moment" % MomentVersion
    / s"$MomentVersion/min/moment-with-locales.js"
    minified "min/moment-with-locales.min.js"
    commonJSName "moment",

  "org.webjars.bower" % "moment-timezone" % MomentTimezoneVersion
    / "moment-timezone-with-data.js"
    minified "builds/moment-timezone-with-data.min.js"
    dependsOn s"moment/$MomentVersion/min/moment-with-locales.js"
)

pomExtra :=
  <url>https://github.com/vpavkin/scala-js-momentjs</url>
    <licenses>
      <license>
        <name>Apache-2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
      </license>
    </licenses>
    <scm>
      <url>git://github.com/vpavkin/scala-js-momentjs.git</url>
    </scm>
    <developers>
      <developer>
        <id>tindzk</id>
        <name>Tim Nieradzik</name>
        <url>http://github.com/tindzk/</url>
      </developer>
      <developer>
        <id>vpavkin</id>
        <name>Vladimir Pavkin</name>
        <url>http://github.com/vpavkin/</url>
      </developer>
    </developers>
