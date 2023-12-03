package com.carloscsanz.dayOne

fun main() {
    val fileName ="/1-trebuchet/calibration.txt"
    val inputStream = object {}.javaClass.getResourceAsStream(fileName)
        ?: throw Exception("Resource $fileName not found")

    var sum = 0
    inputStream.bufferedReader().forEachLine { line ->
        val calibration = PartTwoCalibrationCalculator.getCalibration(line)

        sum += calibration
    }

    println("Answer: $sum")
    // Mal: 53188
}