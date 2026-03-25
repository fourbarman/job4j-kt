package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HtmlTableTest {
    @Test
    fun whenTableThenShouldStartWithTable() {
        val htmlTable = HtmlTable()
        assertThat(htmlTable.table(5, 5)).startsWith("<table>")
    }

    @Test
    fun whenTableThenShouldEndWithTable() {
        val htmlTable = HtmlTable()
        assertThat(htmlTable.table(5, 5)).endsWith("<table>")
    }
}
