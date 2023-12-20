package com.carloscsanz.day7.partOne

import com.carloscsanz.day7.partTwo.FiveOfAKind
import com.carloscsanz.day7.partTwo.FourOfAKind
import com.carloscsanz.day7.partTwo.FullHouse
import com.carloscsanz.day7.partTwo.HighCard
import com.carloscsanz.day7.partTwo.OnePair
import com.carloscsanz.day7.partTwo.ThreeOfAKind
import com.carloscsanz.day7.partTwo.TwoPair

sealed class PartOneHand(
    private val first: PartOneCard,
    private val second: PartOneCard,
    private val third: PartOneCard,
    private val fourth: PartOneCard,
    private val fifth: PartOneCard,
    private val size: Int,
) : Comparable<PartOneHand> {
    companion object {
        fun from(hand: String): PartOneHand = from(
            first = PartOneCard.of(hand[0].toString()),
            second = PartOneCard.of(hand[1].toString()),
            third = PartOneCard.of(hand[2].toString()),
            fourth = PartOneCard.of(hand[3].toString()),
            fifth = PartOneCard.of(hand[4].toString()),
        )

        private fun from(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard): PartOneHand {
            val groups = listOf(first, second, third, fourth, fifth).groupingBy { it }.eachCount().filter { it.value > 0 }
            if (groups.values.any { it == 5 }) return FiveOfAKind(first, second, third, fourth, fifth)
            if (groups.values.any { it == 4 }) return FourOfAKind(first, second, third, fourth, fifth)
            if (groups.values.any { it == 3 } && groups.values.any { it == 2 }) return FullHouse(first, second, third, fourth, fifth)
            if (groups.values.any { it == 3 }) return ThreeOfAKind(first, second, third, fourth, fifth)
            if (groups.values.count { it == 2 } == 2) return TwoPair(first, second, third, fourth, fifth)
            if (groups.values.any { it == 2 }) return OnePair(first, second, third, fourth, fifth)

            return HighCard(first, second, third, fourth, fifth)
        }
    }

    override fun compareTo(other: PartOneHand): Int {
        if (size != other.size) return size.compareTo(other.size)

        if (first != other.first) return first.compareTo(other.first)
        if (second != other.second) return second.compareTo(other.second)
        if (third != other.third) return third.compareTo(other.third)
        if (fourth != other.fourth) return fourth.compareTo(other.fourth)
        if (fifth != other.fifth) return fifth.compareTo(other.fifth)

        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PartOneHand) return false

        if (first != other.first) return false
        if (second != other.second) return false
        if (third != other.third) return false
        if (fourth != other.fourth) return false
        if (fifth != other.fifth) return false
        if (size != other.size) return false

        return true
    }

    override fun hashCode(): Int {
        var result = first.hashCode()
        result = 31 * result + second.hashCode()
        result = 31 * result + third.hashCode()
        result = 31 * result + fourth.hashCode()
        result = 31 * result + fifth.hashCode()
        result = 31 * result + size
        return result
    }
}

class FiveOfAKind(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 7)
class FourOfAKind(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 6)
class FullHouse(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 5)
class ThreeOfAKind(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 4)
class TwoPair(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 3)
class OnePair(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 2)
class HighCard(first: PartOneCard, second: PartOneCard, third: PartOneCard, fourth: PartOneCard, fifth: PartOneCard) : PartOneHand(first, second, third, fourth, fifth, 1)
