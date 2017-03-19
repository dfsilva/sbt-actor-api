import scalariform.formatter.preferences._

sbtPlugin := true

organization := "im.actor"

name := "sbt-actor-api"

version := "0.7.30-xl-SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= Seq(
  "com.eed3si9n" %% "treehugger" % "0.4.1",
  "com.google.protobuf" % "protobuf-java" % "3.1.0",
  "io.spray" %% "spray-json" % "1.3.1",
  "org.specs2" %% "specs2-core" % "2.4.15" % "test"
)

scalariformSettings

ScalariformKeys.preferences :=
  ScalariformKeys.preferences.value
    .setPreference(RewriteArrowSymbols, true)
    .setPreference(AlignParameters, true)
    .setPreference(AlignSingleLineCaseStatements, true)

publishTo := {
  val nexus = "http://nexus.diegosilva.com.br:8081/nexus/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/releases")
}

credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.diegosilva.com.br", "admin", "admin123")

pomExtra := (
  <url>http://github.com/actorapp/sbt-actor-api</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://www.opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:actorapp/sbt-actor-api.git</url>
    <connection>scm:git:git@github.com:actorapp/sbt-actor-api.git</connection>
  </scm>
  <developers>
    <developer>
      <id>prettynatty</id>
      <name>Andrey Kuznetsov</name>
      <url>http://fear.loathing.in</url>
    </developer>
  </developers>
)
