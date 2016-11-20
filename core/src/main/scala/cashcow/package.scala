import cashcow.Price.{Ask, Bid}
import shapeless.tag.@@

package object cashcow {

  implicit final class BidPriceOps(private val wrappedBid: Price @@ Bid) extends AnyVal {
    def toAsk: Price @@ Ask = Price.ask(wrappedBid)
  }

  implicit final class AskPriceOps(private val wrappedAsk: Price @@ Ask) extends AnyVal {
    def toBid: Price @@ Bid = Price.bid(wrappedAsk)
  }

  implicit final class CurrencyOps(private val wrappedCurrency: Currency) extends AnyVal {
    def `/`(counter: Currency): CurrencyPair = CurrencyPair(wrappedCurrency, counter)
  }

}
