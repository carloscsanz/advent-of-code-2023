package com.carloscsanz.day2

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CubeConundrumGameTest {

    private val game = CubeConundrumGame(redCubes = 1, greenCubes = 1, blueCubes = 1)

    @Test
    fun `game should be valid when subset is valid`() {
        val subset = CubeConundrumSubset(RedCube(1), GreenCube(1), BlueCube(1))

        val actual = game.isValid(subset)

        assertTrue(actual)
    }

    @Test
    fun `game should not be valid when subset has more red cubes than the red cubes of the game`() {
        val subset = CubeConundrumSubset(RedCube(2), GreenCube(1), BlueCube(1))

        val actual = game.isValid(subset)

        assertFalse(actual)
    }

    @Test
    fun `game should not be valid when subset has more green cubes than the green cubes of the game`() {
        val subset = CubeConundrumSubset(RedCube(1), GreenCube(2), BlueCube(1))

        val actual = game.isValid(subset)

        assertFalse(actual)
    }

    @Test
    fun `game should not be valid when subset has more blue cubes than the blue cubes of the game`() {
        val subset = CubeConundrumSubset(RedCube(1), GreenCube(1), BlueCube(2))

        val actual = game.isValid(subset)

        assertFalse(actual)
    }
}