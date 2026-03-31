package ru.job4j.safe

import java.time.LocalDate

class Promotion(val name: String, val currency: String, val date: LocalDate) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Promotion) return false
        return name == other.name && currency == other.currency && date == other.date
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + currency.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
