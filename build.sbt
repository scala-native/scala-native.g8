import scala.io.Source
import scala.scalanative.sbtplugin.{ScalaNativePlugin, ScalaNativePluginInternal}
import ScalaNativePlugin.autoImport._

autoCompilerPlugins := true

val toolScalaVersion = "2.10.6"

val libScalaVersion  = "2.11.8"

lazy val platform: Seq[Setting[_]] =
  Seq(
    libraryDependencies ++= Seq(
      "org.scala-native" %% "clib"       % "0.1-SNAPSHOT",
      "org.scala-native" %% "javalib"    % "0.1-SNAPSHOT",
      "org.scala-native" %% "scalalib"   % "0.1-SNAPSHOT"
    ))

lazy val libSettings: Seq[Setting[_]] =
  ScalaNativePlugin.projectSettings ++
    Seq(
      scalaVersion := libScalaVersion,
      nativeEmitDependencyGraphPath := Some(file("out.dot")))

lazy val disableDocs: Seq[Setting[_]] =
  Seq(
      sources in doc in Compile := List())


lazy val root =
  project.in(file("example"))
    .settings(platform)
    .settings(libSettings)
    .settings(disableDocs)
    .settings(
      nativeVerbose := true,
      nativeClangOptions := Seq("-O2"))
