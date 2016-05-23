## For the impatient

### Install Scala Native

Make sure you hava clang-3.7 or superior. See: [Installation script for Debian Jessie]

Make sure you install ``libgc-dev``.
```bash
    $ sudo apt-get install libgc-dev -y
```

```bash
    $ mkdir -p $HOME/workspace
    $ cd $HOME/workspace
    $ git clone https://github.com/scala-native/scala-native.git
	$ cd $HOME/workspace/scala-native
```
Make sure you disable generatio of documentation in ``build.sbt``:
```scala
lazy val baseSettings = Seq(
  organization := "org.scala-native",
  version      := nativeVersion,
  sources in doc in Compile := List(),
  scalafmtConfig := Some(file(".scalafmt"))
)
```
Now you can build it:
```bash
    $ sbt clean publishLocal
```

In case it fails, try ``sbt publishLocal`` again. This is common in case your .ivy2 repository is empty or never had scala-native artifacts published onto it.


### Run this demo application

```bash
    $ mkdir -p $HOME/workspace
    $ cd $HOME/workspace
    $ git clone https://github.com/frgomes/poc-scala-native.git
```

```bash
    $ cd $HOME/workspace/poc-scala-native
    $ sbt clean package
```

**NOTE: regression in master of Scala Native. IT'S GOING TO FAIL HERE TOO!**

```bash
    $ sbt run
```

```bash
    $ sudo apt-get install xdg-utils
    $ xdg-open image0.ppm
```

[installation script for Debian Jessie]: https://gist.github.com/frgomes/daa33b2f7a6489196a95
