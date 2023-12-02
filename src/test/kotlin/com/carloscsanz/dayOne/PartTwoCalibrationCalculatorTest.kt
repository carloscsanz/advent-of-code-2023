package com.carloscsanz.dayOne

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
    )
    fun `should get the calibration number`(line: String, expected: Int) {
        val actual = PartTwoCalibrationCalculator.getCalibration(line)

        assert(actual == expected)
    }
}