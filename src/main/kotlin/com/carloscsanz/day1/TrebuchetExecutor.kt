package com.carloscsanz.day1

import com.carloscsanz.utils.ResourceFile

private const val INPUT_PATH = "/1-trebuchet/calibration.txt"

fun main() {
    val input = ResourceFile.read(INPUT_PATH)

    var partOneSum = 0L
    var partTwoSum = 0L
    input.bufferedReader().forEachLine { line ->
        val trebuchet = CalibrationLine(line)

        // FIRST PART
        partOneSum += trebuchet.basicCalibration

        // SECOND PART
        partTwoSum += trebuchet.complexCalibration
    }

    println("PART 1 - Answer: $partOneSum") // Your puzzle answer was 53080.
    println("PART 2 - Answer: $partTwoSum") // Your puzzle answer was 53268.
}