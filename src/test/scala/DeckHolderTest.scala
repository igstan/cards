package cards
package test

class DeckHolderTest extends FunSuite with Matchers {
  test("rejects nonpositive deck sizes") {
    val _ = intercept[NonpositiveDeckCount] {
      new DeckHolder(-1)
    }
  }

  test("supplies the requested number of cards") {
    val deckHolder = new DeckHolder(1)
    val Some(cards) = deckHolder.getCards(5)
    cards.length should be(5)
  }

  test("supplies *at most* the requested number of cards") {
    val deckHolder = new DeckHolder(1)
    val Some(cards) = deckHolder.getCards(53)
    cards.length should be(52)
  }

  test("jumps to next deck when current one is exhausted") {
    val deckHolder = new DeckHolder(2)
    val Some(cards) = deckHolder.getCards(53)
    cards.length should be(53)
  }

  test("supplies None when exhausted") {
    val deckHolder = new DeckHolder(1)
    deckHolder.getCards(52)
    deckHolder.getCards(1) should be(None)
  }
}
