package cashcow

import shapeless.tag
import shapeless.tag.@@

case class Price(value: BigDecimal)

object Price {

  sealed trait Bid
  val bid = tag[Bid]
  object Bid {
    val zero: Price @@ Bid = 0.0
    implicit def asPrice[A](x: A)(implicit A: AsPrice[A]): Price @@ Bid = Price.bid(A.asPrice(x))
  }

  sealed trait Ask
  val ask = tag[Ask]
  object Ask {
    val zero: Price @@ Ask = 0.0
    implicit def asPrice[A](x: A)(implicit A: AsPrice[A]): Price @@ Ask = Price.ask(A.asPrice(x))
  }

  val zero: Price = 0.0
  implicit def asPrice[A](x: A)(implicit A: AsPrice[A]): Price = A.asPrice(x)

}

trait AsPrice[A] {
  def asPrice(x: A): Price
}

object AsPrice {

  implicit val shortToPrice: AsPrice[Short] = new AsPrice[Short] {
    def asPrice(x: Short): Price = Price(x.toInt)
  }

  implicit val intToPrice: AsPrice[Int] = new AsPrice[Int] {
    def asPrice(x: Int): Price = Price(x)
  }

  implicit val longToPrice: AsPrice[Long] = new AsPrice[Long] {
    def asPrice(x: Long): Price = Price(x)
  }

  implicit val doubleToPrice: AsPrice[Double] = new AsPrice[Double] {
    def asPrice(x: Double): Price = Price(x)
  }

  implicit val bigDecimalToPrice: AsPrice[BigDecimal] = new AsPrice[BigDecimal] {
    def asPrice(x: BigDecimal): Price = Price(x)
  }

}
