package ru.job4j.base

/* Draw X. size > 0 и нечетное */
fun draw(size: Int): List<List<Char>> {
    if ( size < 0 || size % 2 == 0) return emptyList()

    val start = 0
    val rows = ArrayList<List<Char>>()
    for (row in start until size) {
        val rowCells = ArrayList<Char>()
        for (cell in start until size) {
            if (row == cell || row + cell == size - 1) {
                rowCells.add('X')
            } else {
                rowCells.add(' ')
            }
        }
        rows.add(rowCells)
    }
    return rows
}

fun main() {
    draw(11)
}
