lazy val root = project.in(file("."))
  .settings(
    g8TestScript := (baseDirectory in ThisBuild).value / "test"
  )