package ru.job4j.inline

data class Sale(val productName: String, val category: String, val quantitySold: Int, val totalRevenue: Double)

// Фильтрация по категории
fun filterByCategory(sales: List<Sale>, category: String): List<Sale> {
    return filterSales(sales) {it.category == category}
}

// Расчет общей выручки
fun calculateTotalRevenue(sales: List<Sale>): Double {
    return sales.sumOf { it.totalRevenue }
}

// Поиск самых продаваемых продуктов
fun topSellingProducts(sales: List<Sale>, topN: Int): List<Sale> {
    return sales.sortedByDescending { it.quantitySold }.take(topN)
}

// Фильтрация по минимальной выручке
fun filterByMinRevenue(sales: List<Sale>, minRevenue: Double): List<Sale> {
    return filterSales(sales) {it.totalRevenue > minRevenue}
}

inline fun filterSales(
    sales: List<Sale>,
    predicate: (Sale) -> Boolean
): List<Sale> {
    return sales.filter { predicate(it) }
}

// Пример комбинированной операции: фильтрация по категории -> топ-продукты -> общая выручка
fun combinedSalesAnalysis(sales: List<Sale>, category: String, topN: Int): Double {
    val salesByCategory = filterByCategory(sales, category)
    val topSales = topSellingProducts(salesByCategory, topN)
    return calculateTotalRevenue(topSales)
}
