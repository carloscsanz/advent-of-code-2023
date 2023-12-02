package com.carloscsanz.dayOne

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

private val numberWords = setOf(ONE_WORD, TWO_WORD, THREE_WORD, FOUR_WORD, FIVE_WORD, SIX_WORD, SEVEN_WORD, EIGHT_WORD, NINE_WORD)
private val numberWordsMap = mapOf(ONE_WORD to ONE, TWO_WORD to TWO, THREE_WORD to THREE, FOUR_WORD to FOUR, FIVE_WORD to FIVE, SIX_WORD to SIX, SEVEN_WORD to SEVEN, EIGHT_WORD to EIGHT, NINE_WORD to NINE)

object PartTwoCalibrationCalculator {

    fun getCalibration(line: String): Int {
        val combinations = numberWords
            .map { line.replace(it, numberWordsMap[it].toString()) }
            .map { it.replace(Regex("\\D"), "0") }
            .map { it.toLong() }
            .filterNot { it == 0L }
        val max = combinations.max()
        val min = combinations.min()

        return (max.getFirstDigit() * 10) + min.getSecondDigit()
    }

    private fun Long.getFirstDigit(): Int = toString().first().digitToInt()

    private fun Long.getSecondDigit(): Int = toString().reversed().toLong().getFirstDigit()
}