package com.carloscsanz.day7

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CardTest {

    @Nested
    inner class CardATest {

        private val card = A

        @ParameterizedTest
        @CsvSource("K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("A")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardKTest {

        private val card = K

        @ParameterizedTest
        @CsvSource("Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("K")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardQTest {

        private val card = Q

        @ParameterizedTest
        @CsvSource("J", "T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("Q")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardJTest {

        private val card = J

        @ParameterizedTest
        @CsvSource("T", "9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("J")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardTTest {

        private val card = T

        @ParameterizedTest
        @CsvSource("9", "8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("T")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardNineTest {

        private val card = Nine

        @ParameterizedTest
        @CsvSource("8", "7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("9")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardEightTest {

        private val card = Eight

        @ParameterizedTest
        @CsvSource("7", "6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("8")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardSevenTest {

        private val card = Seven

        @ParameterizedTest
        @CsvSource("6", "5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("7")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardSixTest {

        private val card = Six

        @ParameterizedTest
        @CsvSource("5", "4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("6")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardFiveTest {

        private val card = Five

        @ParameterizedTest
        @CsvSource("4", "3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("5")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardFourTest {

        private val card = Four

        @ParameterizedTest
        @CsvSource("3", "2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("4")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardThreeTest {

        private val card = Three

        @ParameterizedTest
        @CsvSource("2")
        fun `card is bigger than the rest`(value: String) {
            val other = Card.of(value)

            assertTrue(card > other)
        }

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("3")

            assertEquals(card, other)
        }
    }

    @Nested
    inner class CardTwoTest {

        private val card = Two

        @Test
        fun `card should be equal the same card`() {
            val other = Card.of("2")

            assertEquals(card, other)
        }
    }
}