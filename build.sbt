import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

sbtPlugin := true

organization := "im.actor"

name := "sbt-actor-api"

version := "0.7.34-SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

libraryDependencies ++= Seq(
  "com.eed3si9n" %% "treehugger" % "0.4.3",
  "com.google.protobuf" % "protobuf-java" % "3.1.0",
  "io.spray" %% "spray-json" % "1.3.3"
)

scalariformSettings

ScalariformKeys.preferences :=
  ScalariformKeys.preferences.value
    .setPreference(RewriteArrowSymbols, true)
    .setPreference(AlignParameters, true)
    .setPreference(AlignSingleLineCaseStatements, true)

publishTo := {
  val nexus = "http://nexus.diegosilva.com.br:8081/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/releases")
}

credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.diegosilva.com.br", "admin", "admin123")

