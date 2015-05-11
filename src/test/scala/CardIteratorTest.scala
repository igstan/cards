package cards
package test

class CardIteratorTest extends FunSuite with Matchers {
  def suits = {
    CardIterator.ordered.toList.groupBy(_.suit)
  }

  test("produces 52 cards") {
    CardIterator.ordered.length should be(52)
  }

  test("produces all suits") {
    suits.keys should be(Set(Spades, Diamonds, Hearts, Clubs))
  }

  test("produces 13 cards for each suit") {
    Set(Spades, Diamonds, Hearts, Clubs).foreach { suit =>
      suits(suit).length should be(13)
    }
  }

  test("spades respect value range") {
    suits(Spades).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("diamonds respect value range") {
    suits(Diamonds).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("hearts respect value range") {
    suits(Hearts).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("clubs respect value range") {
    suits(Clubs).map(_.value).toSet should be(1.to(13).toSet)
  }
}
