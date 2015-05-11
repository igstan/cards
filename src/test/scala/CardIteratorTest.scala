package cards
package test

class CardIteratorTest extends FunSuite with Matchers {
  test("produces 52 cards") {
    CardIterator.pristine.length should be(52)
  }

  test("produces all suits") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)
    suits.keys should be(Set(Spades, Diamonds, Hearts, Clubs))
  }

  test("produces 13 cards for each suit") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)

    Set(Spades, Diamonds, Hearts, Clubs).foreach { suit =>
      suits(suit).length should be(13)
    }
  }

  test("spades respect value range") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)
    suits(Spades).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("diamonds respect value range") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)
    suits(Diamonds).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("hearts respect value range") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)
    suits(Hearts).map(_.value).toSet should be(1.to(13).toSet)
  }

  test("clubs respect value range") {
    val cards = CardIterator.pristine.toList
    val suits = cards.groupBy(_.suit)
    suits(Clubs).map(_.value).toSet should be(1.to(13).toSet)
  }
}
