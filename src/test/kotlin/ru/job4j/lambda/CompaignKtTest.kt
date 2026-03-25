package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class CompaignKtTest {
    @Test
    fun whenStringCompaignsThenReturnListOfStrings() {
        val expected = listOf(
            "New Line, Address(city=Moscow, street=Lenina, houseNumber=10), 2024-02-15",
            "Spring sale, Address(city=Saint Petersburg, street=Nevsky Prospect, houseNumber=25), 2020-12-30",
            "GreenHouse, Address(city=Kazan, street=Baumana, houseNumber=7), 2018-05-20",
            "NorthFaith, Address(city=Novosibirsk, street=Sovetskaya, houseNumber=42), 2006-10-01"
        )
        val list = listOf(
            Compaign("New Line",
                Address("Moscow", "Lenina", "10"),
                LocalDate.of(2024, 2, 15)),
            Compaign("Spring sale",
                Address("Saint Petersburg", "Nevsky Prospect", "25"),
                LocalDate.of(2020, 12, 30)),
            Compaign("GreenHouse",
                Address("Kazan", "Baumana", "7"),
                LocalDate.of(2018, 5, 20)),
            Compaign("NorthFaith",
                Address("Novosibirsk", "Sovetskaya", "42"),
                LocalDate.of(2006, 10, 1))
        )

        val result = stringCompaigns(list)
        assertThat(result).isEqualTo(expected)
    }
}
