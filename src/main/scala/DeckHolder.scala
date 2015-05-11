package cards

case class NonpositiveDeckCount(count: Int) extends RuntimeException(s"nonpositive deck count: $count")

class DeckHolder(count: Int) extends Iterator[Card] {
  if (count < 1) {
    throw new NonpositiveDeckCount(count)
  }

  private[this] val decks = Iterator.fill(count) { Deck.shuffled }
  private[this] var deck = decks.next()

  override def hasNext = {
    deck.hasNext || decks.hasNext
  }

  override def next(): Card = {
    if (!deck.hasNext) {
      deck = decks.next()
    }

    deck.next()
  }

  def getCards(count: Int): Option[Vector[Card]] = {
    if (hasNext) {
      Some(this.take(count).toVector)
    } else {
      None
    }
  }

  def shuffle(): Unit = {
    deck.shuffle()
  }
}
