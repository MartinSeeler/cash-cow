package cashcow

import shapeless.tag
import shapeless.tag._

case class Timestamp(value: Long)

object Timestamp {

  sealed trait Millis
  val millis = tag[Millis]

  object Millis {
    implicit def asTimestamp[A](x: A)(implicit A: AsTimestamp[A]): Timestamp @@ Millis = Timestamp.millis(A.asTimestamp(x))
  }

  sealed trait Nanos
  val nanos = tag[Nanos]

  object Nanos {
    implicit def asTimestamp[A](x: A)(implicit A: AsTimestamp[A]): Timestamp @@ Nanos = Timestamp.nanos(A.asTimestamp(x))
  }

}

sealed trait AsTimestamp[A] {
  def asTimestamp(x: A): Timestamp
}

object AsTimestamp {

  implicit val intToTimestamp: AsTimestamp[Int] = new AsTimestamp[Int] {
    def asTimestamp(x: Int): Timestamp = Timestamp(x)
  }

  implicit val longToTimestamp: AsTimestamp[Long] = new AsTimestamp[Long] {
    def asTimestamp(x: Long): Timestamp = Timestamp(x)
  }

}
