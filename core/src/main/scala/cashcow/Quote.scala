package cashcow

import cashcow.Price.{Ask, Bid}
import cashcow.Timestamp.Nanos
import shapeless.tag.@@

case class Quote(time: Timestamp @@ Nanos, bid: Price @@ Bid, ask: Price @@ Ask) {

  val mid: Price = (bid.value + ask.value) / 2.0

}
