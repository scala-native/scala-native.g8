## For the impatient

### Install Scala Native

Make sure you have clang-3.7 or superior. See: [Installation script for Debian Jessie]

Make sure you install ``libgc-dev``.
```bash
    $ sudo apt-get install libgc-dev -y
```

Downloading...
```bash
    $ mkdir -p $HOME/workspace
    $ cd $HOME/workspace
    $ git clone https://github.com/scala-native/scala-native.git
    $ cd $HOME/workspace/scala-native
```

Make sure you disable generation of documentation in ``build.sbt``:
```scala
lazy val baseSettings = Seq(
  organization := "org.scala-native",
  version      := nativeVersion,
  sources in doc in Compile := List(),
  scalafmtConfig := Some(file(".scalafmt"))
)
```

Clean your Ivy repository and proceed with the build:
```bash
    $ rm -r -f $HOME/.ivy2/local/org.scala-native
    $ sbt clean rtlib/publishLocal nscplugin/publishLocal publishLocal
```

### Building this demo application
```bash
    $ mkdir -p $HOME/workspace
    $ cd $HOME/workspace
    $ git clone https://github.com/frgomes/poc-scala-native.git
    $ cd $HOME/workspace/poc-scala-native
    $ sbt clean package
```

**NOTE: regression in master of Scala Native. IT'S GOING TO FAIL HERE TOO!**

```bash
    $ sbt run
```

See the image produced:
```bash
    $ sudo apt-get install xdg-utils
    $ xdg-open image0.ppm
```

[installation script for Debian Jessie]: https://gist.github.com/frgomes/daa33b2f7a6489196a95
