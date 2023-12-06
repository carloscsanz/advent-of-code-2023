package com.carloscsanz.day6

class Race(
    /** The record distance in this race in millimeters. */
    val distance: Long,
    /** The race duration in milliseconds. */
    val record: Long
) {

    val winningAttempts = (0..record).map { calculateDistance(it) }.count { it > distance }

    private fun calculateDistance(loadTime: Long): Long {
        val racingTime = record - loadTime

        return loadTime * racingTime
    }
}

fun main() {

//    Time:      7  15   30
//    Distance:  9  40  200

    val races = listOf(
        Race(distance = 9, record = 7),
        Race(distance = 40, record = 15),
        Race(distance = 200, record = 30),
    )

    val solution = races.map { it.winningAttempts }.reduce { a, b -> a * b }

    println("Answer is: $solution")

//    Time:        46     85     75     82
//    Distance:   208   1412   1257   1410

    val officialRaces = listOf(
        Race(distance = 208, record = 46),
        Race(distance = 1412, record = 85),
        Race(distance = 1257, record = 75),
        Race(distance = 1410, record = 82),
    )

    val firsPartSolution = officialRaces.map { it.winningAttempts }.reduce { a, b -> a * b }

    println("Answer is: $firsPartSolution")


//    Time:      71530
//    Distance:  940200

    val partTwoExampleRace = Race(distance = 940200, record = 71530)

    val partTwoExampleSolution = partTwoExampleRace.winningAttempts

    println("Answer is: $partTwoExampleSolution")

//    Time:        46857582
//    Distance:   208141212571410

    val partTwoRace = Race(distance = 208141212571410, record = 46857582)

    val partTwoSolution = partTwoRace.winningAttempts

    println("Answer is: $partTwoSolution")

}