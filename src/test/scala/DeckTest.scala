package cards
package test

class DeckTest extends FunSuite with Matchers {
  test("supplies the requested number of cards") {
    val deck = new Deck
    val Some(cards) = deck.getCards(5)
    cards.size should be(5)
  }

  test("supplies *at most* the requested number of cards") {
    val deck = new Deck
    deck.getCards(50)
    val Some(cards) = deck.getCards(5)
    cards.size should be(2)
  }

  test("supplies None when exhausted") {
    val deck = new Deck
    deck.getCards(52)
    deck.getCards(5) should be(None)
  }
}
