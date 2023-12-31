package com.carloscsanz.day7

import com.carloscsanz.day7.partOne.PartOneHand
import com.carloscsanz.day7.partTwo.Hand
import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH = "/7-camel-cards/game.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    val cards = input
        .bufferedReader()
        .lineSequence()
        .map { line ->
            val round = line.parseLine()

            println("$line - ${round.partTwoHand.javaClass.simpleName}")

            round
        }
        .toList()

    // FIRST PART
    val partOneSum = cards
        .asSequence()
        .sortedBy { it.partOneHand }
        .mapIndexed { index, gameRound -> (index + 1) * gameRound.bid }
        .sum()

    // FIRST PART
    val partTwoSum = cards
        .asSequence()
        .sortedBy { it.partTwoHand }
        .mapIndexed { index, gameRound -> (index + 1) * gameRound.bid }
        .sum()

    println("PART 1 - Answer: $partOneSum") // Your puzzle answer was 251216224.
    println("PART 2 - Answer: $partTwoSum") // Your puzzle answer was 250825971.
}

data class GameRound(
    val partOneHand: PartOneHand,
    val partTwoHand: Hand,
    val bid: Int
)

private fun String.parseLine(): GameRound {
    val parts = split(" ")
    val partOneHand = PartOneHand.from(parts.first())
    val partTwoHand = Hand.from(parts.first())
    val bid = parts.last().toInt()

    return GameRound(partOneHand, partTwoHand, bid)
}
