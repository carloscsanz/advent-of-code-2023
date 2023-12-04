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

private val numberWords = setOf(ONE_WORD, TWO_WORD, THREE_WORD, FOUR_WORD, FIVE_WORD, SIX_WORD, SEVEN_WORD, EIGHT_WORD, NINE_WORD)
private val numberWordsMap = mapOf(ONE_WORD to ONE, TWO_WORD to TWO, THREE_WORD to THREE, FOUR_WORD to FOUR, FIVE_WORD to FIVE, SIX_WORD to SIX, SEVEN_WORD to SEVEN, EIGHT_WORD to EIGHT, NINE_WORD to NINE)


class CalibrationLine(private val line: String) {

    val basicCalibration: Long
        get() {
            val digits = line.getDigits(checkWordNumbers = false)
            val firstDigit = digits.first()
            val secondDigit = digits.last()

            val digit = "$firstDigit$secondDigit"

            return digit.toLong()
        }

    val complexCalibration = run {
        val digits = line.getDigits(checkWordNumbers = true)
        val firstDigit = digits.first()
        val secondDigit = digits.last()

        val digit = "$firstDigit$secondDigit"

        digit.toLong()
    }

    private fun String.getDigits(checkWordNumbers: Boolean): List<Char> {
        return withIndex()
            .map { subSequence(it.index, length).toString() }
            .mapNotNull { it.getDigit(checkWordNumbers) }
    }

    private fun String.getDigit(checkWordNumbers: Boolean): Char? {
        return when {
            isEmpty() -> null
            first().isDigit() -> first()
            checkWordNumbers && startsWithWordDigit() -> getWordDigit()
            else -> null
        }
    }

    private fun String.getWordDigit(): Char {
        val word = numberWords.first { startsWith(it) }

        return numberWordsMap.getValue(word)
    }

    private fun String.startsWithWordDigit(): Boolean = numberWords.any { startsWith(it) }
}
