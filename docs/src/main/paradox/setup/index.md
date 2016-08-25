## Setup

This is what you will be doing, in a nutshell:

* installation of LLVM and Clang (if needed!)
* installation of libgc-dev
* run *this* application and see the output generated

#### Installing LLVM and CLang

**NOTE:** If you already have LLVM >= 3.7 and Clang >= 3.7 installed in your system, you probably can skip to the next section.

You can install LLVM and Clang from their APT repository:
* [Installation script for Debian Jessie]

In case the LLVM APT repository is down, please install from pre-built binaries:

* Under section "Download LLVM 3.8.0", look for section [Pre-Build Binaries]

**This is an example on how you can install the pre-built binaries:**

<pre>
    # This is an example on how you can install the pre-built binaries
    $ mkdir -p $HOME/Downloads && cd $HOME/Downloads
    $ wget http://llvm.org/releases/3.8.0/clang+llvm-3.8.0-x86_64-linux-gnu-debian8.tar.xz
    $ mkdir -p $HOME/tools/developer && cd $HOME/tools/developer
    $ tar xpf $HOME/Downloads/clang+llvm-3.8.0-x86_64-linux-gnu-debian8.tar.xz
    $ export PATH=$HOME/tools/developer/clang+llvm-3.8.0-x86_64-linux-gnu-debian8/bin:$PATH
    $ hash -r
</pre>


#### Installing libgc-dev
```bash
    $ sudo apt-get install libgc-dev -y --force-yes
```

#### Run *this* application and see the output generated

Run the example application
```bash
    $ sbt run
```

Install xdg-open, which will help you open the generated image, like shown below:
```bash
    $ sudo apt-get install xdg-utils
    $ xdg-open image0.ppm
```


## Troubleshooting

Some problems observed and well known solutions:

* In case the build fails, and you are using ``sbt-coursier`` plugin, try to remove its cache at ``$HOME/.coursier`` or try to remove the plugin from the SBT configuration.


## For advanced users only

If your application needs features only available in most recent Scala Native sources, not yet
available in public Maven repositories, you will probably find the instructions below useful.

#### Building and installing Scala Native

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
  sources in doc in Compile := List(), // doc generation currently broken
  scalafmtConfig := Some(file(".scalafmt"))
)
```

Clean everything involving scala-native under your Ivy repository. Then proceed with the build:
```bash
    $ find $HOME/.ivy2 -type d -name '*scala-native*' | xargs rm -r -f
    $ sbt clean nscplugin/publishLocal nativelib/publishLocal publishLocal
```
