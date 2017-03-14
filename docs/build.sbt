enablePlugins(ScalaNativePlugin)
enablePlugins(ParadoxPlugin)

scalaVersion := "2.11.8"

name := "scala-native-example-docs"

paradoxTheme := Some(builtinParadoxTheme("generic"))

lazy val deploy = taskKey[Unit]("Deploy pages for github docs")

deploy := {
  IO.copyDirectory(
    target.value / "paradox" / "site",
    file("."),
    overwrite = true,
    preserveLastModified = true)
}
