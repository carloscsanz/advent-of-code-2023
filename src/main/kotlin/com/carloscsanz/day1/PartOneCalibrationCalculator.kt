package com.carloscsanz.day1

private val numbers = setOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

object PartOneCalibrationCalculator {

    fun getCalibration(line: String): Int {
        val firstDigit = line.first { it in numbers }
        val lastDigit = line.reversed().first { it in numbers }

        return (firstDigit.digitToInt() * 10) + lastDigit.digitToInt()
    }
}