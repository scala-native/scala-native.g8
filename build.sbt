import scala.scalanative.sbtplugin.ScalaNativePlugin

name := "example"

scalaVersion := "2.11.8"

sources in doc in Compile := List()

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++=
  ScalaNativePlugin.runtimeDependencies

ScalaNativePlugin.projectSettings

nativeVerbose := true

nativeClangOptions ++= Seq("-O2")

//nativeEmitDependencyGraphPath := Some(file("out.dot")))
