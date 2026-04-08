package ru.job4j.inline

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SaleTest {
    private lateinit var sales: List<Sale>

    @BeforeEach
    fun init() {
        sales = listOf(
            Sale("Laptop", "Electronics", 10, 5000.0),
            Sale("Smartphone", "Electronics", 20, 3000.0),
            Sale("Tablet", "Electronics", 15, 2000.0),
            Sale("Headphones", "Accessories", 50, 1500.0),
            Sale("Charger", "Accessories", 100, 1000.0)
        )
    }

    @Test
    fun whenFilterByCategoryThenReturnFiltered() {
        assertThat(filterByCategory(sales, "Electronics")).containsExactlyInAnyOrder(
            Sale("Laptop", "Electronics", 10, 5000.0),
            Sale("Smartphone", "Electronics", 20, 3000.0),
            Sale("Tablet", "Electronics", 15, 2000.0)
        )
    }

    @Test
    fun whenFilterByCategoryAndNoElementsThenReturnEmptyList() {
        assertThat(filterByCategory(sales, "Food")).isEmpty()
    }

    @Test
    fun whenCalculateTotalRevenueThenReturnTotalRevenue() {
        assertThat(calculateTotalRevenue(sales)).isCloseTo(12500.0, within(0.01))
    }

    @Test
    fun whenCalculateTotalRevenueAndNoElementsThenReturnZero() {
        assertThat(calculateTotalRevenue(listOf())).isCloseTo(0.0, within(0.01))
    }

    @Test
    fun whenTopSellingProductsThenReturnTopSellingProducts() {
        assertThat(topSellingProducts(sales, 2)).containsExactlyInAnyOrder(
            Sale("Headphones", "Accessories", 50, 1500.0),
            Sale("Charger", "Accessories", 100, 1000.0)
        )
    }

    @Test
    fun whenTopSellingProductsAndNoElementsThenReturnEmptyList() {
        assertThat(topSellingProducts(listOf(), 1)).isEmpty()
    }

    @Test
    fun whenFilterByMinRevenueEquals2900ThenReturnListOfTwoSales() {
        assertThat(filterByMinRevenue(sales, 2900.0)).containsExactlyInAnyOrder(
            Sale("Laptop", "Electronics", 10, 5000.0),
            Sale("Smartphone", "Electronics", 20, 3000.0)
        )
    }

    @Test
    fun whenFilterByMinRevenue4000ThenReturnListOfOneSale() {
        assertThat(filterByMinRevenue(sales, 4000.0)).containsExactlyInAnyOrder(
            Sale("Laptop", "Electronics", 10, 5000.0)
        )
    }

    @Test
    fun whenFilterByMinRevenue5000ThenReturnEmptyList() {
        assertThat(filterByMinRevenue(sales, 5000.0)).isEmpty()
    }

    @Test
    fun whenFilterByMinRevenueAndNoElementsThenReturnEmptyList() {
        assertThat(filterByMinRevenue(listOf(), 1000.0)).isEmpty()
    }

    @Test
    fun whenCombinedSalesAnalysisThenReturnTotalRevenue() {
        assertThat(combinedSalesAnalysis(sales, "Electronics", 2)).isCloseTo(5000.0, within(0.01))
    }
}