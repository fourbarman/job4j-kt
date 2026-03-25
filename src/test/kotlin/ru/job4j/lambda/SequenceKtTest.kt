package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SequenceKtTest {
    @Test
    fun whenCountListOfFourThenReturnSum8() {
        val list = listOf(1, 2, 3, 4)

        assertThat(count(list)).isEqualTo(8)
    }

    @Test
    fun whenCountListOfTenThenReturnSum35() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        assertThat(count(list)).isEqualTo(35)
    }

    @Test
    fun whenCountListOfNoEvenThenReturnSum0() {
        val list = listOf(1, 3, 5)

        assertThat(count(list)).isEqualTo(0)
    }
}
