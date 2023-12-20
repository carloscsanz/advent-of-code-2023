package com.carloscsanz.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class HandTest {

    @Nested
    inner class FiveOfAKindTest {

        private val hand = FiveOfAKind(K, K, K, K, K)

        @Test
        fun `hand is bigger than other`() {
            val other = Hand.from("QQQQQ")

            assertTrue(hand > other)
        }

        @Test
        fun `hand should be equal the same hand`() {
            val other = Hand.from("KKKKK")

            assertEquals(hand, other)
        }

        @Test
        fun `hand should be smaller than other`() {
            val other = Hand.from("AAAAA")

            assertTrue(hand < other)
        }
    }

}