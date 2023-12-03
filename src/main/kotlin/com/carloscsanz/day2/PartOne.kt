package com.carloscsanz.day2

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH ="/2-cube-conundrum/games.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    val cubeConundrum = CubeConundrum(redCubes = 12, greenCubes = 13, blueCubes = 14)

    var sum = 0
    input.bufferedReader().forEachLine { line ->
        val game = CubeConundrum.Game.from(line)

        if (cubeConundrum.isValid(game)) {
            sum += game.id
        } else {
            println("Line not valid: $line")
        }
    }

    println("Answer: $sum")
}
