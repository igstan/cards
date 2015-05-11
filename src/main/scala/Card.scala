package cards

sealed trait Suit
case object Spades extends Suit
case object Diamonds extends Suit
case object Hearts extends Suit
case object Clubs extends Suit

case class Card(value: Int, suit: Suit)
