package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalcTest {
    @Test
    fun when1plus1then2() {
        assertThat(add(1, 1)).isEqualTo(2)
    }

    @Test
    fun when1minus1thenZero() {
        assertThat(substruct(1, 1)).isEqualTo(0)
    }

    @Test
    fun when1multiplyOn1then1() {
        assertThat(multiplication(1, 1)).isEqualTo(1)
    }

    @Test
    fun when6multiplyOn2then12() {
        assertThat(multiplication(6, 2)).isEqualTo(12)
    }

    @Test
    fun when6divideBy2then3() {
        assertThat(division(6, 2)).isEqualTo(3)
    }

    @Test
    fun when6divideBy4then1() {
        assertThat(division(6, 4)).isEqualTo(1)
    }

    @Test
    fun when6divideBy4thenNot1AndAHalf() {
        assertThat(division(6, 4)).isNotEqualTo(2)
    }

    @Test
    fun when6divideByZeroThenThrowArithmeticException() {
        assertThatThrownBy { division(6, 0) }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessage("/ by zero")
    }
}