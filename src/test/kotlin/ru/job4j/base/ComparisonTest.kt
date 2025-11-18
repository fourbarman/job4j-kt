package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComparisonTest {
    @Test
    fun whenMaxWith1And1Then1() {
        assertThat(max(1, 1)).isEqualTo(1)
    }

    @Test
    fun whenMaxWith1And2Then2() {
        assertThat(max(1, 2)).isEqualTo(2)
    }

    @Test
    fun whenMaxWith2And1Then2() {
        assertThat(max(2, 1)).isEqualTo(2)
    }

    @Test
    fun whenMaxWith1And1And1Then1() {
        assertThat(max(1, 1, 1)).isEqualTo(1)
    }

    @Test
    fun whenMaxWith1And2And3Then3() {
        assertThat(max(1, 2, 3)).isEqualTo(3)
    }

    @Test
    fun whenMaxWith1And2And1Then3() {
        assertThat(max(3, 2, 1)).isEqualTo(3)
    }

    @Test
    fun whenMaxWith1And3And2Then3() {
        assertThat(max(1, 3, 2)).isEqualTo(3)
    }
}

