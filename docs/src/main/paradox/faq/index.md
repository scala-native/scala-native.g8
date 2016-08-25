## FAQ

#### What Scala is?

[Scala] is a functional programming language originally based on the JVM (Java Virtual Machine), which means that the compiler generates _bytecode_ to be executed by the JVM, instead of generating _native code_.

#### What Scala Native is?

Scala Native is pretty much Scala (as explained above), but able to generate _native code_ to be executed by the _target platform_, in other words: executed directly on the "bare metal", instead of being executed by the JVM.

#### Which target platforms are supported?

Short answer: OSX and Linux.

Long answer: Scala Native employs something called [LLVM], which does the job of generating the binary code for a given platform. So, the answer is, in principle: all platforms supported by LLVM. In reality, supporting a platform involves other aspects too, not simply delegating the task to LLVM. So, stay tuned to [Scala Native] in this regard.

#### Can I write code in Scala Native which is able to run in a browser?

You can use [ScalaJS] for that. ScalaJS is pretty much Scala (as explained above), but able to generate JavaScript, instead of generating _bytecode_ for the JVM. Using ScalaJS (and not Scala Native!), you can write code in Scala and generate JavaScript which a browser is able to understand.

#### Scala Native employs AOT and not JIT... OK, what does it mean?

The Scala Native compiler generates _native code_ for the _target platform_ and optimizes the code _ahead of time_ (AOT) of the execution of your program.

In contrast, Scala generates _bytecode_ for a _virtual machine_ and optimizes the code _just in time_ (JIT) with the execution of your program. In other words, the JIT compiler transforms _bytecode_ onto _native code_ behind the scenes, whilst your program is executing.

#### Should I use Scala with JIT or Scala Native with AOT?

It depends. If you are interested in binary portability across platforms, the answer is Scala with JIT. If you need fast startup times, or get rid of the JVM, or integrating system languages... the answer is Scala Native. If you are interested on writing code to run in a browser, the answer is ScalaJS.

#### What a system language is?

It basically means that you are able to write system software, such as native libraries and other executable binaries targetting specific platforms. In other words, a system language generates _native code_, able to run straight onto the "bare metal". You can even write an operating system with a system language or a combination of system languages.

#### Can I link Scala Native code with binaries from other languages?

At the time of this writing, Scala Native allows linking with C. Work is in progress in order to allow other programming languages. There are annotations which are intended to inform the linker about the foreign language symbol to be associated to variables and functions of your Scala Native code.

#### Does Scala Native with AOT performs better than Scala with JIT?

In regards to startup times, the answer is clearly _yes!_. In regards to other aspects, it's a bit early to tell.

The subjects "performance" and "benchmarks" involve several aspects which may behave in different ways, depending on the way these aspects are put together.

#### So, I do not need the JVM anymore, right?

Hum.... not really. You still need [SBT] in order to build Scala Native and _this_ project. And SBT needs the JVM. But you don't need the JVM on the target platform.

#### Will I be free of the JVM someday?

When [SBT] gets compiled with Scala Native. This is possibly a difficult task, which will take a while to happen or even eventually never happens.

A much more promissing alternative is another build tool called [CBT] being compiled with Scala Native. Since CBT has a much simpler code base than SBT, chances are that porting CBT to Scala Native is a relatively simple task. Since CBT is a new project, there's no ecosystem around it, which means that there's no commitment with past or risk of breaking plugins, for example.

#### Do I need LLVM for running a Scala Native program?

No. In the tutorial above you ran ``sbt run``, which creates an executable and immediately launches it. But you could have employed the command ``sbt nativeLink`` instead, which just creates the executable, without running it, as shown below:
```bash
    $ sbt nativeLink
    $ ls target/scala-2.11/scala-native-example-out
    $ target/scala-2.11/scala-native-example-out
    $ xdg-open image0.ppm
```
This way, you can deploy only the executable to the target platform, and nothing else.
