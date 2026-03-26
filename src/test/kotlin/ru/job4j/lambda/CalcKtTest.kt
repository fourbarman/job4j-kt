package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.Test

class CalcKtTest() {
    @Test
    fun whenAddThenShouldReturnSum() {
        val add = operation("add")
        assertThat(add(5.0, 3.0)).isCloseTo(8.0, within(0.1))
    }

    @Test
    fun whenAdd2ThenShouldReturnSum() {
        val add = operation("add")
        assertThat(add(5.0, 3.0)).isCloseTo(8.0, within(0.1))
    }

    @Test
    fun whenSubtractThenShouldReturnSubtracted() {
        val subtract = operation("subtract")
        assertThat(subtract(5.0, 3.0)).isCloseTo(2.0, within(0.1))
    }

    @Test
    fun whenMultiplyThenShouldReturnMultiplied() {
        val multiply = operation("multiply")
        assertThat(multiply(5.0, 3.0)).isCloseTo(15.0, within(0.1))
    }

    @Test
    fun whenDivideThenShouldReturnDivided() {
        val divide = operation("divide")
        assertThat(divide(5.0, 3.0)).isCloseTo(1.6, within(0.1))
    }

    @Test
    fun whenNotSupportedThenShouldReturnNaN() {
        val notSupported = operation("notSupported")
        assertThat(notSupported(5.0, 3.0)).isNaN()
    }

    @Test
    fun whenNPowerThenShouldReturnPowered() {
        val power = operation("power")
        assertThat(power(5.0, 3.0)).isCloseTo(125.0, within(0.1))
    }
}
