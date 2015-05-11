package cards

import scala.util.Random

/**
 * An iterator producing all possible combinations of a standard 52-card deck.
 */
class CardIterator private (shuffle: Boolean) extends Iterator[Card] {
  // We use six bits to represent all possible card combinations. The first
  // two bits encode the suit, while the next four encode the value.
  //
  // bbbb bb
  //  ^   ^
  //  |   |
  //  |   +——— suit
  //  +——————— value
  //
  // We need 52 combinations, but because the bit patterns for the numbers 0,
  // 1, 2 and 3 all have the "value" part of 0, we ignore them. Which is why
  // we start from 4 upto 55, instead of 0 upto 52.
  //
  // Example: here are the first four generated cards and their bit patterns:
  //
  // 0001 00 -> Card(1, Spades)
  // 0001 01 -> Card(1, Diamonds)
  // 0001 10 -> Card(1, Hearts)
  // 0001 11 -> Card(1, Clubs)
  //
  private[this] var numbers =
    if (shuffle) Random.shuffle(4 to 55) else 4 to 55

  override def hasNext = {
    numbers.nonEmpty
  }

  override def next(): Card = {
    val number = numbers.head
    numbers = numbers.tail
    val first2bits = number & 0x03
    val next4bits = number >> 2
    Card(next4bits, suit(first2bits))
  }

  def shuffle(): Unit = {
    numbers = Random.shuffle(numbers)
  }

  private def suit(n: Int): Suit = {
    (n: @annotation.switch) match {
      case 0 => Spades
      case 1 => Diamonds
      case 2 => Hearts
      case 3 => Clubs
    }
  }
}

object CardIterator {
  def ordered = new CardIterator(shuffle = false)
  def shuffled = new CardIterator(shuffle = true)
}
