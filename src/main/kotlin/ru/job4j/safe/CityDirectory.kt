package ru.job4j.safe

class CityDirectory {
    val cityList : List<City> by lazy { loadCities() }

    private fun loadCities() : List<City> = listOf(
        City("Moscow"),
        City("Berlin")
    )
}

data class City(val name: String)
