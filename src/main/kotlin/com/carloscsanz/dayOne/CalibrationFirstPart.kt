package com.carloscsanz.dayOne

private val numbers = setOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

fun main() {
    val fileName ="/day-1-calibration/calibration.txt"
    val inputStream = object {}.javaClass.getResourceAsStream(fileName)
        ?: throw Exception("Resource $fileName not found")

    var sum = 0
    inputStream.bufferedReader().forEachLine { line ->
        val firstDigit = line.first { it in numbers }
        val lastDigit = line.reversed().first { it in numbers }
        val lineNumber = (firstDigit.digitToInt() * 10) + lastDigit.digitToInt()

        sum += lineNumber
    }

    println("Answer: $sum")
}