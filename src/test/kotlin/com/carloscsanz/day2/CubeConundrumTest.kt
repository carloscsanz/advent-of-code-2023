package com.carloscsanz.day2

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CubeConundrumTest {

    private val cubeConundrum = CubeConundrum(redCubes = 1, greenCubes = 1, blueCubes = 1)

    @Test
    fun `game should be valid when subset is valid`() {
        val game = CubeConundrum.Game(
            id = 1,
            CubeConundrum.Subset(RedCube(1), GreenCube(1), BlueCube(1)),
            CubeConundrum.Subset(BlueCube(1)),
        )

        val actual = cubeConundrum.isValid(game)

        assertTrue(actual)
    }

    @Test
    fun `game should not be valid when subset has more red cubes than the red cubes of the game`() {
        val game = CubeConundrum.Game(
            id = 1,
            CubeConundrum.Subset(RedCube(1), GreenCube(1), BlueCube(1)),
            CubeConundrum.Subset(RedCube(2)),
        )

        val actual = cubeConundrum.isValid(game)

        assertFalse(actual)
    }

    @Test
    fun `game should not be valid when subset has more green cubes than the green cubes of the game`() {
        val game = CubeConundrum.Game(
            id = 1,
            CubeConundrum.Subset(RedCube(1), GreenCube(1), BlueCube(1)),
            CubeConundrum.Subset(GreenCube(2)),
        )

        val actual = cubeConundrum.isValid(game)

        assertFalse(actual)
    }

    @Test
    fun `game should not be valid when subset has more blue cubes than the blue cubes of the game`() {
        val game = CubeConundrum.Game(
            id = 1,
            CubeConundrum.Subset(RedCube(1), GreenCube(1), BlueCube(1)),
            CubeConundrum.Subset(BlueCube(2)),
        )

        val actual = cubeConundrum.isValid(game)

        assertFalse(actual)
    }

    @Test
    fun `should create game from line`(){
        val line = "Game 1: 1 blue, 2 green, 3 red; 7 red, 8 green; 1 green, 2 red, 1 blue; 2 green, 3 red, 1 blue; 8 green, 1 blue"

        CubeConundrum.Game.from(line)
    }
}