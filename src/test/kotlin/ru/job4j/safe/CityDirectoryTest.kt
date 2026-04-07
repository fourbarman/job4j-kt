package ru.job4j.safe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CityDirectoryTest {
    @Test
    fun whenCallThenInit() {
        val cityDirectory = CityDirectory()
        assertThat(cityDirectory.cityList).containsExactlyInAnyOrder(City("Moscow"), City("Berlin"))
    }
}