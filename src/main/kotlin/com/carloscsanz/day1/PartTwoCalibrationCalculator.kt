package com.carloscsanz.day1

private const val ONE = '1'
private const val TWO = '2'
private const val THREE = '3'
private const val FOUR = '4'
private const val FIVE = '5'
private const val SIX = '6'
private const val SEVEN = '7'
private const val EIGHT = '8'
private const val NINE = '9'

private const val ONE_WORD = "one"
private const val TWO_WORD = "two"
private const val THREE_WORD = "three"
private const val FOUR_WORD = "four"
private const val FIVE_WORD = "five"
private const val SIX_WORD = "six"
private const val SEVEN_WORD = "seven"
private const val EIGHT_WORD = "eight"
private const val NINE_WORD = "nine"

private const val WILDCARD = "0"

private val numbers = setOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)
private val numberWords = setOf(ONE_WORD, TWO_WORD, THREE_WORD, FOUR_WORD, FIVE_WORD, SIX_WORD, SEVEN_WORD, EIGHT_WORD, NINE_WORD)
private val numberWordsMap = mapOf(ONE_WORD to ONE, TWO_WORD to TWO, THREE_WORD to THREE, FOUR_WORD to FOUR, FIVE_WORD to FIVE, SIX_WORD to SIX, SEVEN_WORD to SEVEN, EIGHT_WORD to EIGHT, NINE_WORD to NINE)

object PartTwoCalibrationCalculator {

    fun getCalibration(line: String): Int {
        val combinations = numberWords.asSequence()
            .map { line.replace(it, numberWordsMap[it].toString()) }.toSet()
            .map { it.replace(Regex("\\D"), WILDCARD) }
        val maxSizeLine = combinations.maxOfOrNull { it.length }!!
        val sortedLines = combinations
            .minus(WILDCARD.repeat(maxSizeLine))
            .map { combination ->
                if (combination.length != maxSizeLine) {
                    val diff = maxSizeLine - combination.length
                    WILDCARD.repeat(diff) + combination
                } else combination
            }

        val max = sortedLines.getCalibration()
        val min = sortedLines.reverseAllElements().getCalibration()
        val calibration = (max * 10) + min

        println("> line: $line calibration: $calibration ")

        return calibration
    }

    private fun Collection<String>.reverseAllElements(): Collection<String> = map { it.reversed() }

    private fun Collection<String>.getCalibration(): Int = max().first { it in numbers }.digitToInt()
}