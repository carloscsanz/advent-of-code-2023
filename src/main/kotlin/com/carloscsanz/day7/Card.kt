package com.carloscsanz.day7

sealed class Card(private val size: Int): Comparable<Card> {
    companion object {
        fun of(card: String): Card {
            return when (card) {
                "A" -> A
                "K" -> K
                "Q" -> Q
                "J" -> J
                "T" -> T
                "9" -> Nine
                "8" -> Eight
                "7" -> Seven
                "6" -> Six
                "5" -> Five
                "4" -> Four
                "3" -> Three
                "2" -> Two
                else -> throw IllegalArgumentException("Unknown card $card")
            }
        }
    }

    override fun compareTo(other: Card): Int = size.compareTo(other.size)
}

data object A : Card(14)
data object K : Card(13)
data object Q : Card(12)
data object J : Card(11)
data object T : Card(10)
data object Nine : Card(9)
data object Eight : Card(8)
data object Seven : Card(7)
data object Six : Card(6)
data object Five : Card(5)
data object Four : Card(4)
data object Three : Card(3)
data object Two : Card(2)
