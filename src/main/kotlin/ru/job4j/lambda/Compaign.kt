package ru.job4j.lambda

import java.time.LocalDate

data class Compaign(val name: String, val address: Address, val created: LocalDate)

data class Address(
    val city: String,
    val street: String,
    val houseNumber: String)

fun stringCompaigns(compaigns: List<Compaign>): List<String> {
    return compaigns.map {"${it.name}, ${it.address}, ${it.created}"}
}
