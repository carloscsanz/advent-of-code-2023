package com.carloscsanz.day4

import kotlin.math.pow

class Card(winningNumbers: Set<Int>, myNumbers: Set<Int>) {
    companion object {
        fun from(line: String): Card {
            val (_, game) = line.split(": ")
            val (winningNumbersLine, myNumbersLine) = game.split(" | ")

            val winningNumbers = "[0-9]+".toRegex().findAll(winningNumbersLine).map { it.value.toInt() }.toSet()
            val myNumbers = "[0-9]+".toRegex().findAll(myNumbersLine).map { it.value.toInt() }.toSet()

            return Card(winningNumbers, myNumbers)
        }
    }

    private val winners = winningNumbers.intersect(myNumbers)

    val points: Int = if (winners.isEmpty()) 0 else 2.toDouble().pow((winners.size-1).toDouble()).toInt()

}