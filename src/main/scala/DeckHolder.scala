package cards

case class NonpositiveDeckCount(deckCount: Int) extends RuntimeException(s"nonpositive deck count: $deckCount")

class DeckHolder(private[this] var deckCount: Int) {
  if (deckCount < 1) {
    throw new NonpositiveDeckCount(deckCount)
  }

  private[this] var deck = new Deck

  def getCards(count: Int): Option[Vector[Card]] = {
    getCardsRecursive(count, None)
  }

  @annotation.tailrec
  private def getCardsRecursive(count: Int, result: Option[Vector[Card]]): Option[Vector[Card]] = {
    if (count == 0 || deckCount == 0) {
      result
    } else {
      deck.getCards(count) match {
        case None =>
          deck = new Deck
          deckCount -= 1
          getCardsRecursive(count, result)
        case Some(cards) =>
          val vec = cards.toVector
          val res = result.map(_ ++ vec).orElse(Some(vec))
          getCardsRecursive(count - cards.size, res)
      }
    }
  }

  def shuffle(): Unit = {
    deck.shuffle()
  }
}
