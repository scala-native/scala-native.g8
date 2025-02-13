scalaVersion := "3.3.5" // A Long Term Support version.

enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
logLevel := Level.Info

// import to add Scala Native options
import scala.scalanative.build._

// defaults set with common options shown
nativeConfig ~= { c =>
  c.withSourceLevelDebuggingConfig(
    SourceLevelDebuggingConfig.enabled
  ) // enable rich stacktraces
}
