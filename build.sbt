
name := "example"

scalaVersion := "2.11.8"

sources in doc in Compile := List()

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  compilerPlugin("org.scala-native" %  "tools_2.10" % "0.1-SNAPSHOT"),
  compilerPlugin("org.scala-native" %  "nir_2.10"   % "0.1-SNAPSHOT"),
  compilerPlugin("org.scala-native" %  "util_2.10"  % "0.1-SNAPSHOT"),
                 "org.scala-native" %% "javalib"    % "0.1-SNAPSHOT",
                 "org.scala-native" %% "scalalib"   % "0.1-SNAPSHOT",
                 "org.scala-native" %% "nativelib"  % "0.1-SNAPSHOT"
)

scala.scalanative.sbtplugin.ScalaNativePlugin.projectSettings

nativeVerbose := true

nativeClangOptions ++= Seq("-O2")

//nativeEmitDependencyGraphPath := Some(file("out.dot")))
