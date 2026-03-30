package ru.job4j.safe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class PurchaseKtTest() {
    @Test
    fun whenGenerateTableWithFilledAddressThenReturnHtmlTableWithFilledAddress() {
        val expected =
            """
                |<!DOCTYPE html>
                |<html>
                |<head>
                |<title>Purchase list</title>
                |</head>
                |<body>
                |<table>
                |<tr><th>Name</th><th>Created</th><th>Address</th></tr>
                |<tr><td>bread</td><td>2026-03-30</td><td>123456 Lenina 12</td></tr>
                |<tr><td>car</td><td>2026-03-30</td><td>123024 Karla Marksa 144</td></tr>
                |</table>
                |</body>
                |</html>
            """.trimMargin()

        val list = listOf(
            Purchase("bread", LocalDate.of(2026, 3, 30), Address("Lenina", "12", Zip("123456"))),
            Purchase("car", LocalDate.of(2026, 3, 30), Address("Karla Marksa", "144", Zip("123024"))),
        )

        assertThat(generateTable(list)).isEqualTo(expected)
    }

    @Test
    fun whenGenerateTableWithEmptyAddressThenReturnHtmlTableWithEmptyAddress() {
        val expected =
            """
                |<!DOCTYPE html>
                |<html>
                |<head>
                |<title>Purchase list</title>
                |</head>
                |<body>
                |<table>
                |<tr><th>Name</th><th>Created</th><th>Address</th></tr>
                |<tr><td>bread</td><td>2026-03-30</td><td>123456 Lenina 12</td></tr>
                |<tr><td>car</td><td>2026-03-30</td><td>  </td></tr>
                |</table>
                |</body>
                |</html>
            """.trimMargin()

        val list = listOf(
            Purchase("bread", LocalDate.of(2026, 3, 30), Address("Lenina", "12", Zip("123456"))),
            Purchase("car", LocalDate.of(2026, 3, 30), null),
        )

        assertThat(generateTable(list)).isEqualTo(expected)
    }
}
