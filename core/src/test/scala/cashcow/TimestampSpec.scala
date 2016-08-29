package cashcow

import cashcow.Timestamp._
import org.scalacheck.Prop._
import org.scalacheck._
import org.scalatest.Matchers
import shapeless.tag.@@

object TimestampSpec extends Properties("Timestamp") with Matchers {

  property("fromInt without a precision tag") = forAll { x: Int =>
    "val p: Timestamp = x" shouldNot compile
    true
  }

  property("fromInt with millisecond precision") = forAll { x: Int =>
    val p: Timestamp @@ Millis = x
    p.value == x
  }

  property("fromInt with nanosecond precision") = forAll { x: Int =>
    val p: Timestamp @@ Nanos = x
    p.value == x
  }

  property("fromLong without a precision tag") = forAll { x: Long =>
    "val p: Timestamp = x" shouldNot compile
    true
  }

  property("fromLong with millisecond precision") = forAll { x: Long =>
    val p: Timestamp @@ Millis = x
    p.value == x
  }

  property("fromLong with nanosecond precision") = forAll { x: Long =>
    val p: Timestamp @@ Nanos = x
    p.value == x
  }

}
