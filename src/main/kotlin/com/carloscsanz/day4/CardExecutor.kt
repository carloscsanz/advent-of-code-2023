package com.carloscsanz.day4

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH ="/4-scratchcards/cards.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    var pointsSum = 0
    input.bufferedReader().forEachLine { line ->
        val card = Card.from(line)

        // FIRST PART
        pointsSum += card.points
    }

    println("PART 1 - Answer: $pointsSum")
    println("PART 2 - Answer: ")
}
