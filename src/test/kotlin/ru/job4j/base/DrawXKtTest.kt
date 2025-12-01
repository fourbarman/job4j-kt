package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DrawXKtTest {

    @Test
    fun whenSizeLessZeroThenReturnEmptyList() {
        val rows = draw(-1)
        assertThat(rows).isEmpty()
    }

    @Test
    fun whenSizeIsEvenThenReturnEmptyList() {
        val rows = draw(8)
        assertThat(rows).isEmpty()
    }

    @Test
    fun whenSize1ThenListSizeIs1And1X() {
        val rows = draw(1)
        val expected = listOf(
            listOf('X'))

        assertThat(rows.size).isEqualTo(1)
        assertThat(rows).isEqualTo(expected)
    }

    @Test
    fun whenSize3ThenSizeIs3AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val rows = draw(3)

        val expected = listOf(
            listOf('X', ' ', 'X'),
            listOf(' ', 'X', ' '),
            listOf('X', ' ', 'X'))

        assertThat(rows.size).isEqualTo(3)
        assertThat(rows).isEqualTo(expected)
    }

    @Test
    fun whenSize5ThenSizeIs5AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val rows = draw(5)

        val expected = listOf(
            listOf('X', ' ', ' ', ' ', 'X'),
            listOf(' ', 'X', ' ', 'X', ' '),
            listOf(' ', ' ', 'X', ' ', ' '),
            listOf(' ', 'X', ' ', 'X', ' '),
            listOf('X', ' ', ' ', ' ', 'X'))

        assertThat(rows.size).isEqualTo(5)
        assertThat(rows).isEqualTo(expected)
    }

    @Test
    fun whenSize11ThenSizeIs11AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val rows = draw(11)

        assertThat(rows.size).isEqualTo(11)
        rows.forEach { row ->
            assertThat(row).hasSize(11)
        }
    }
}
