package cards

/**
 * An iterator producing all possible combinations of a standard 52-card deck.
 */
class CardIterator extends Iterator[Card] {
  // We use six bits to represent all possible card combinations. The first
  // two bits encode the suit, while the next four encode the value.
  //
  // bbbb bb
  //  ^   ^
  //  |   |
  //  |   +——— suit
  //  +——————— value
  //
  // Normally, we need 52 combinations, but because the bit patterns for the
  // numbers 0, 1 and 2 all have the "value" part of 0, we ignore them. Which
  // is why we start from 55 downto 3, instead of 52 downto 0.
  //
  // Example: here are the first four generated cards and their bit patterns:
  //
  // 0001 00 -> Card(1, Spades)
  // 0001 01 -> Card(1, Diamonds)
  // 0001 10 -> Card(1, Hearts)
  // 0001 11 -> Card(1, Clubs)
  //
  private[this] var counter = 55

  override def hasNext = {
    counter > 3
  }

  override def next(): Card = {
    val first2bits = counter & 0x03
    val next4bits = counter >> 2
    counter -= 1
    Card(next4bits, suit(first2bits))
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
  def pristine = new CardIterator
}
