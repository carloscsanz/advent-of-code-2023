package com.carloscsanz.day7

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH = "/7-camel-cards/game.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    val cards = input
        .bufferedReader()
        .lineSequence()
        .map { line -> line.parseLine() }

    // FIRST PART
    val partOneSum = cards
        .sortedBy { it.hand }
        .mapIndexed { index, gameRound -> (index + 1) * gameRound.bid }
        .sum()

    println("PART 1 - Answer: $partOneSum") // Your puzzle answer was 251216224.
    // println("PART 2 - Answer: $partTwoSum") // Your puzzle answer was 53268.
}

data class GameRound(val hand: Hand, val bid: Int)

private fun String.parseLine(): GameRound {
    val parts = split(" ")
    val hand = Hand.from(parts.first())
    val bid = parts.last().toInt()

    return GameRound(hand, bid)
}
