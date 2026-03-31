package ru.job4j.safe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate

class PromotionTest {

    @Test
    fun whenSameReferenceThenEqualsReturnsTrue() {
        val promotion = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))

        assertThat(promotion).isEqualTo(promotion)
    }

    @Test
    fun whenAllFieldsAreEqualThenObjectsAreEqual() {
        val first = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))
        val second = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))

        assertThat(first).isEqualTo(second)
        assertThat(second).isEqualTo(first)
    }

    @Test
    fun whenNamesAreDifferentThenObjectsAreNotEqual() {
        val first = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))
        val second = Promotion("Promo", "USD", LocalDate.of(2024, 3, 10))

        assertThat(first).isNotEqualTo(second)
    }

    @Test
    fun whenCurrenciesAreDifferentThenObjectsAreNotEqual() {
        val first = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))
        val second = Promotion("Sale", "EUR", LocalDate.of(2024, 3, 10))

        assertThat(first).isNotEqualTo(second)
    }

    @Test
    fun whenDatesAreDifferentThenObjectsAreNotEqual() {
        val first = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))
        val second = Promotion("Sale", "USD", LocalDate.of(2024, 3, 11))

        assertThat(first).isNotEqualTo(second)
    }

    @Test
    fun whenCompareWithNullThenEqualsReturnsFalse() {
        val promotion = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))

        assertThat(promotion.equals(null)).isFalse()
    }

    @Test
    fun whenCompareWithAnotherTypeThenEqualsReturnsFalse() {
        val promotion = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))

        assertThat(promotion.equals("not a promotion")).isFalse()
    }

    @Test
    fun whenObjectsAreEqualThenHashCodesAreEqual() {
        val first = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))
        val second = Promotion("Sale", "USD", LocalDate.of(2024, 3, 10))

        assertThat(first.hashCode()).isEqualTo(second.hashCode())
    }
}

