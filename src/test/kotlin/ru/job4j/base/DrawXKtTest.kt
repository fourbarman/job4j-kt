package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Test

class DrawXKtTest {
    private val xCond: Condition<Char> = Condition(
        { c -> c.equals('X') },
        "X"
    )

    @Test
    fun whenSizeLessZeroThenReturnEmptyList() {
        val xList = draw(-1)
        assertThat(xList).isEmpty()
    }

    @Test
    fun whenSizeIsEvenThenReturnEmptyList() {
        val xList = draw(8)
        assertThat(xList).isEmpty()
    }

    @Test
    fun whenSize1ThenListSizeIs1And1X() {
        val xList = draw(1)
        assertThat(xList.size).isEqualTo(1)
        assertThat(xList[0].size).isEqualTo(1)
        assertThat(xList[0]).haveExactly(1, xCond)
    }

    @Test
    fun whenSize3ThenSizeIs3AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val xList = draw(3)

        val firstList = 0
        val middleList = xList.size / 2
        val lastList = xList.size - 1

        assertThat(xList.size).isEqualTo(3)
        assertThat(xList[firstList].size).isEqualTo(3)
        assertThat(xList[middleList].size).isEqualTo(3)
        assertThat(xList[lastList].size).isEqualTo(3)

        assertThat(xList[firstList]).haveExactly(2, xCond)
        assertThat(xList[middleList]).haveExactly(1, xCond)
        assertThat(xList[lastList]).haveExactly(2, xCond)
    }

    @Test
    fun whenSize5ThenSizeIs5AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val xList = draw(5)

        val firstList = 0
        val middleList = xList.size / 2
        val lastList = xList.size - 1

        assertThat(xList.size).isEqualTo(5)
        assertThat(xList[firstList].size).isEqualTo(5)
        assertThat(xList[middleList].size).isEqualTo(5)
        assertThat(xList[lastList].size).isEqualTo(5)

        assertThat(xList[firstList]).haveExactly(2, xCond)
        assertThat(xList[middleList]).haveExactly(1, xCond)
        assertThat(xList[lastList]).haveExactly(2, xCond)
    }

    @Test
    fun whenSize11ThenSizeIs11AndFirstListWith2XAndMiddleWith1XAndLastWith2X() {
        val xList = draw(11)

        val firstList = 0
        val middleList = xList.size / 2
        val lastList = xList.size - 1

        assertThat(xList.size).isEqualTo(11)
        assertThat(xList[firstList].size).isEqualTo(11)
        assertThat(xList[middleList].size).isEqualTo(11)
        assertThat(xList[lastList].size).isEqualTo(11)

        assertThat(xList[firstList]).haveExactly(2, xCond)
        assertThat(xList[middleList]).haveExactly(1, xCond)
        assertThat(xList[lastList]).haveExactly(2, xCond)
    }
}
