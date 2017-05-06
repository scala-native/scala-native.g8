import scala.scalanative.native._, stdio._

object Foo {
  def main(args: Array[String]): Unit = {
    fprintf(stderr, toCString(Bar.a.toString))
  }
}
