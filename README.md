## Overview

This project intends to serve as a template for projects employing [Scala Native].

For an introduction for the completely newbie on the subject, please find the FAQ down below.


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

## FAQ

#### What Scala is?

[Scala] is a functional programming language originally based on the JVM (Java Virtual Machine), which means that the compiler generates _bytecode_ to be executed by the JVM, instead of generating _native code_.

#### What Scala Native is?

Scala Native is pretty much Scala (as explained above), but able to generate _native code_ to be executed by the _target platform_, in other words: executed directly on the "bare metal", instead of being executed by the JVM.

#### Which target platforms are supported?

Scala Native employs something called LLVM, which does the job of generating the binary code for a given platform. So, the answer is, in principle: all platforms supported by [LLVM].

#### Can I write code in Scala Native which is able to run in a browser?

You can use [ScalaJS] for that. ScalaJS pretty much Scala (as explained above), but able to generate JavaScript, instead of generating _bytecode_ for JVM. Using ScalaJS (and not Scala Native!), you can write code in Scala and generate JavaScript which the browser is able to understand.

#### Scala Native employs AOT and not JIT... OK, what does it mean?

The Scala Native compiler generates _native code_ for the _target platform_ and optimizes the code _ahead of time_ (AOT) of the execution of your program.

In contrast, Scala generates _bytecode_ for a _virtual machine_ and optimizes the code _just in time_ (JIT) with the execution of your program.

#### Should I use Scala with JIT or Scala Native with AOT?

It depends. If you are interested in binary portability across platforms, the answer is Scala with JIT. If you need fast startup times, or get rid of the JVM, or integrating system languages... the answer is Scala Native. If you are interested on writing code to run in the browser, the answer is ScalaJS.

#### What a system language is?

It basically means that you are able to write system software, such as native libraries, like .DLLs, .LIBs, .EXEs for the Windows platforms, or their counterparts for other platforms. In other words, a system language generates _native code_, able to run straight onto the "bare metal".

#### So, I do not need the JVM anymore, right?

Hum.... not really. You still need SBT in order to build Scala Native and _this_ project. And SBT needs the JVM. But you don't need the JVM on the target platform.

#### Do I need LLVM for running a Scala Native program?

Yes, at the moment... yes. Ideally, you shouldn't.




[installation script for Debian Jessie]: https://gist.github.com/frgomes/daa33b2f7a6489196a95
[LLVM]: http://llvm.org
[Scala]: http://scala-lang.org
[ScalaJS]: http://scala-js.org
[Scala Native]: http://scala-native.org
