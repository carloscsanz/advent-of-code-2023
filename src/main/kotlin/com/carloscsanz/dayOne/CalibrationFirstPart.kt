package com.carloscsanz.dayOne

fun main() {
    val fileName ="/1-trebuchet/calibration.txt"
    val inputStream = object {}.javaClass.getResourceAsStream(fileName)
        ?: throw Exception("Resource $fileName not found")

    var sum = 0
    inputStream.bufferedReader().forEachLine { line ->
        val calibration = PartOneCalibrationCalculator.getCalibration(line)

        sum += calibration
    }

    // Your puzzle answer was 53080.
    println("Answer: $sum")
}