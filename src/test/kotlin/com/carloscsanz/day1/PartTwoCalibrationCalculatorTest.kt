package com.carloscsanz.day1

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PartTwoCalibrationCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "two1nine, 29",
        "eightwothree, 83",
        "abcone2threexyz, 13",
        "xtwone3four, 24",
        "4nineeightseven2, 42",
        "zoneight234, 14",
        "7pqrstsixteen, 76",
        "eight9fhstbssrplmdlncmmqqnklb39ninejz, 89",
        "ppjvndvknbtpfsncplmhhrlh5, 55",
        "mqtwooneeight7sevenfourht, 24",
        "qkpbblqtk6fourvgvdvnsdhnktgqzhxrm, 64"
    )
    fun `should get the calibration number`(line: String, expected: Long) {
        val actual = CalibrationLine(line)

        assert(expected == actual.complexCalibration)
    }
}