package com.carloscsanz.day7.partOne

import com.carloscsanz.day7.partTwo.A
import com.carloscsanz.day7.partTwo.Eight
import com.carloscsanz.day7.partTwo.Five
import com.carloscsanz.day7.partTwo.Four
import com.carloscsanz.day7.partTwo.J
import com.carloscsanz.day7.partTwo.K
import com.carloscsanz.day7.partTwo.Nine
import com.carloscsanz.day7.partTwo.Q
import com.carloscsanz.day7.partTwo.Seven
import com.carloscsanz.day7.partTwo.Six
import com.carloscsanz.day7.partTwo.T
import com.carloscsanz.day7.partTwo.Three
import com.carloscsanz.day7.partTwo.Two

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
