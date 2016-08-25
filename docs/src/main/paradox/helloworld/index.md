## Hello World

If you have reached this section you probably have a system that is now able to compile and run Scala Native programs.

Start within a new folder,
and create a file ```project/plugins.sbt``` as follows:

@@snip [build.sbt](../../../../../project/plugins.sbt)

define a new ```build.sbt```:

@@snip [build.sbt](../../../../../build.sbt)

and now you can write your first application in ```./src/main/scala/HelloWorld.scala```:

@@snip [HelloWorld.scala](../../scala/HelloWorld.scala)

now simply run ```sbt run``` to get everything compiled and have the expected output!
