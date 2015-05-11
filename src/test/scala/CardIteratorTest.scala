package cards
package test

class CardIteratorTest extends FunSpec with Matchers {
  describe("an ordered iterator") {
    def suits = {
      CardIterator.ordered.toList.groupBy(_.suit)
    }

    it("produces 52 cards") {
      CardIterator.ordered.length should be(52)
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

  describe("a shuffled iterator") {
    def suits = {
      CardIterator.shuffled.toList.groupBy(_.suit)
    }

    it("produces 52 cards") {
      CardIterator.shuffled.length should be(52)
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
