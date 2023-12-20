package com.carloscsanz.day7.partOne

sealed class PartOneCard(private val size: Int): Comparable<PartOneCard> {
    companion object {
        fun of(card: String): PartOneCard {
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

    override fun compareTo(other: PartOneCard): Int = size.compareTo(other.size)
}

data object A : PartOneCard(14)
data object K : PartOneCard(13)
data object Q : PartOneCard(12)
data object J : PartOneCard(11)
data object T : PartOneCard(10)
data object Nine : PartOneCard(9)
data object Eight : PartOneCard(8)
data object Seven : PartOneCard(7)
data object Six : PartOneCard(6)
data object Five : PartOneCard(5)
data object Four : PartOneCard(4)
data object Three : PartOneCard(3)
data object Two : PartOneCard(2)
