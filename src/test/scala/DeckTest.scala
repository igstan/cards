package cards
package test

class DeckTest extends FunSpec with Matchers {
  describe("an ordered deck") {
    verify(Deck.ordered)
  }

  describe("a shuffled deck") {
    verify(Deck.shuffled)
  }

  def verify(deck: => Deck): Unit = {
    def suits = {
      deck.toList.groupBy(_.suit)
    }

    it("produces 52 cards") {
      deck.length should be(52)
    }

    it("produces all suits") {
      suits.keys should be(Set(Spades, Diamonds, Hearts, Clubs))
    }

    it("produces 13 cards for each suit") {
      Set(Spades, Diamonds, Hearts, Clubs).foreach { suit =>
        suits(suit).length should be(13)
      }
    }

    it("spades respect value range") {
      suits(Spades).map(_.value).toSet should be(1.to(13).toSet)
    }

    it("diamonds respect value range") {
      suits(Diamonds).map(_.value).toSet should be(1.to(13).toSet)
    }

    it("hearts respect value range") {
      suits(Hearts).map(_.value).toSet should be(1.to(13).toSet)
    }

    it("clubs respect value range") {
      suits(Clubs).map(_.value).toSet should be(1.to(13).toSet)
    }
  }
}
