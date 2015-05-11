package cards

class Deck {
  private[this] var cards = CardIterator.shuffled

  def getCards(count: Int): Option[Set[Card]] = {
    if (cards.hasNext) Some(cards.take(count).toSet) else None
  }

  def shuffle(): Unit = {
    cards.shuffle()
  }
}
