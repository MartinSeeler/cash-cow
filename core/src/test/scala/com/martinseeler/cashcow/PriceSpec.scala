package com.martinseeler.cashcow

import org.scalacheck._
import Prop._
import com.martinseeler.cashcow.Price._
import shapeless.tag.@@

object PriceSpec extends Properties("Price") {

  property("fromInt") = forAll { x: Int =>
    val p: Price = x
    p.value == x
  }

  property("fromDouble") = forAll { x: Double =>
    val p: Price = x
    p.value == x
  }

  property("fromShort") = forAll { x: Short =>
    val p: Price = x
    p.value == x
  }

  property("fromBigDecimal") = forAll { x: BigDecimal =>
    val p: Price = x
    p.value == x
  }

  property("fromLong") = forAll { x: Long =>
    val p: Price = x
    p.value == x
  }

  property("fromInt as Bid") = forAll { x: Int =>
    val p: Price @@ Bid = x
    p.value == x
  }

  property("fromInt as Ask") = forAll { x: Int =>
    val p: Price @@ Ask = x
    p.value == x
  }

  property("from Bid to Ask") = forAll { x: Int =>
    val a: Price @@ Bid = x
    val b: Price @@ Ask = a.toAsk
    b.value == x
  }

  property("from Ask to Bid") = forAll { x: Int =>
    val a: Price @@ Ask = x
    val b: Price @@ Bid = a.toBid
    b.value == x
  }

}
