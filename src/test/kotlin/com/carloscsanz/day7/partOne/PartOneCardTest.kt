package com.carloscsanz.day7.partOne

import com.carloscsanz.day7.partTwo.A
import com.carloscsanz.day7.partTwo.Eight
import com.carloscsanz.day7.partTwo.Five
import com.carloscsanz.day7.partTwo.Four
import com.carloscsanz.day7.partTwo.J
import com.carloscsanz.day7.partTwo.K
import com.carloscsanz.day7.partTwo.Nine
import com.carloscsanz.day7.partTwo.Q
import com.carloscsanz.day7.partTwo.Seven
import com.carloscsanz.day7.partTwo.Six
import com.carloscsanz.day7.partTwo.T
import com.carloscsanz.day7.partTwo.Three
import com.carloscsanz.day7.partTwo.Two
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PartOneCardTest {

    @Nested
    inner class PartOneCardATest {

        private val card = A

        @ParameterizedTest
        @CsvSource("K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("A")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardKTest {

        private val card = K

        @ParameterizedTest
        @CsvSource("Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("K")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardQTest {

        private val card = Q

        @ParameterizedTest
        @CsvSource("J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("Q")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardJTest {

        private val card = J

        @ParameterizedTest
        @CsvSource("T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("J")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardTTest {

        private val card = T

        @ParameterizedTest
        @CsvSource("9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("T")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardNineTest {

        private val card = Nine

        @ParameterizedTest
        @CsvSource("8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("9")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardEightTest {

        private val card = Eight

        @ParameterizedTest
        @CsvSource("7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("8")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardSevenTest {

        private val card = Seven

        @ParameterizedTest
        @CsvSource("6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("7")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardSixTest {

        private val card = Six

        @ParameterizedTest
        @CsvSource("5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("6")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardFiveTest {

        private val card = Five

        @ParameterizedTest
        @CsvSource("4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("5")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardFourTest {

        private val card = Four

        @ParameterizedTest
        @CsvSource("3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("4")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardThreeTest {

        private val card = Three

        @ParameterizedTest
        @CsvSource("2")
        fun `card is bigger than the rest`(value: String) {
            val other = PartOneCard.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("3")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class PartOneCardTwoTest {

        private val card = Two

        @Test
        fun `card should be equal the same card`() {
            val other = PartOneCard.of("2")

            assertEquals(card, other)
        }
    }
}