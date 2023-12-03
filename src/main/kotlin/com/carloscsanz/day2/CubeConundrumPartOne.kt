package com.carloscsanz.day2

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH ="/2-cube-conundrum/games.txt"

class CubeConundrumPartOne {
    val input = ResourceFile.read(INPUT_PATH)
}



class CubeConundrumGame(
    private val redCubes: Int,
    private val greenCubes: Int,
    private val blueCubes: Int,
) {
    fun isValid(subset: CubeConundrumSubset): Boolean {
        val redCubes = subset.cubes.filterIsInstance<RedCube>().sumOf { it.times }
        val greenCubes = subset.cubes.filterIsInstance<GreenCube>().sumOf { it.times }
        val blueCubes = subset.cubes.filterIsInstance<BlueCube>().sumOf { it.times }

        if (this.redCubes < redCubes) return false
        if (this.greenCubes < greenCubes) return false
        if (this.blueCubes < blueCubes) return false

        return true
    }
}

class CubeConundrumSubset(vararg val cubes: Cube)

sealed class Cube(val times: Int)
class RedCube(times: Int): Cube(times)
class GreenCube(times: Int): Cube(times)
class BlueCube(times: Int): Cube(times)
