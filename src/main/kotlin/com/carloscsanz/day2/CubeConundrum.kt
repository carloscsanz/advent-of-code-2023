package com.carloscsanz.day2

class CubeConundrum(
    private val redCubes: Int,
    private val greenCubes: Int,
    private val blueCubes: Int,
) {
    fun isValid(game: Game): Boolean {
        if (this.redCubes < game.maxRedCubes) return false
        if (this.greenCubes < game.maxGreenCubes) return false
        if (this.blueCubes < game.maxBlueCubes) return false

        return true
    }

    class Game(val id: Int, vararg revealedCubes: Subset) {
        companion object {
            fun from(line: String): Game {
                val (gameId, gameData) = line.split(": ")
                val id = "[0-9]+".toRegex().find(gameId)!!.value.toInt()
                val subsets = gameData.split("; ").map { Subset.from(it) }

                return Game(id, *subsets.toTypedArray())
            }
        }

        val maxRedCubes = revealedCubes.maxOf { it.redCubes }
        val maxGreenCubes = revealedCubes.maxOf { it.greenCubes }
        val maxBlueCubes = revealedCubes.maxOf { it.blueCubes }

        val power = maxRedCubes * maxGreenCubes * maxBlueCubes
    }

    class Subset(vararg cubes: Cube){
        val redCubes = cubes.filterIsInstance<RedCube>().sumOf { it.times }
        val greenCubes = cubes.filterIsInstance<GreenCube>().sumOf { it.times }
        val blueCubes = cubes.filterIsInstance<BlueCube>().sumOf { it.times }

        companion object {
            fun from(line: String): Subset {
                val redCubes = "([0-9]+) red".toRegex().findAll(line).map { it.groupValues[1] }.joinToString()
                val greenCubes = "([0-9]+) green".toRegex().findAll(line).map { it.groupValues[1] }.joinToString()
                val blueCubes = "([0-9]+) blue".toRegex().findAll(line).map { it.groupValues[1] }.joinToString()

                val cubes = listOfNotNull(
                    if (redCubes.isEmpty()) null else RedCube(redCubes.toInt()),
                    if (greenCubes.isEmpty()) null else GreenCube(greenCubes.toInt()),
                    if (blueCubes.isEmpty()) null else BlueCube(blueCubes.toInt())
                )

                return Subset(*cubes.toTypedArray())
            }
        }
    }
}
