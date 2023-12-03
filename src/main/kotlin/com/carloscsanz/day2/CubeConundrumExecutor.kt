package com.carloscsanz.day2

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH ="/2-cube-conundrum/games.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    val cubeConundrum = CubeConundrum(redCubes = 12, greenCubes = 13, blueCubes = 14)

    var validIdSum = 0
    var powerSum = 0
    input.bufferedReader().forEachLine { line ->
        val game = CubeConundrum.Game.from(line)

        // FIRST PART
        if (cubeConundrum.isValid(game)) validIdSum += game.id

        // SECOND PART
        powerSum += game.power
    }

    println("PART 1 - Answer: $validIdSum")
    println("PART 2 - Answer: $powerSum")
}
