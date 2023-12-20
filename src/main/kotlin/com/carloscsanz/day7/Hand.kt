package com.carloscsanz.day7

sealed class Hand(
    private val first: Card,
    private val second: Card,
    private val third: Card,
    private val fourth: Card,
    private val fifth: Card,
    private val size: Int,
) : Comparable<Hand> {
    companion object {
        fun from(hand: String): Hand = from(
            first = Card.of(hand[0].toString()),
            second = Card.of(hand[1].toString()),
            third = Card.of(hand[2].toString()),
            fourth = Card.of(hand[3].toString()),
            fifth = Card.of(hand[4].toString()),
        )

        private fun from(first: Card, second: Card, third: Card, fourth: Card, fifth: Card): Hand {
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

    override fun compareTo(other: Hand): Int {
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
        if (other !is Hand) return false

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

class FiveOfAKind(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 7)
class FourOfAKind(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 6)
class FullHouse(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 5)
class ThreeOfAKind(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 4)
class TwoPair(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 3)
class OnePair(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 2)
class HighCard(first: Card, second: Card, third: Card, fourth: Card, fifth: Card) : Hand(first, second, third, fourth, fifth, 1)
