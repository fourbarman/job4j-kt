package ru.job4j.base

private const val ELEVEN = 11

/* Draw X. size > 0 и нечетное */
fun draw(size: Int): List<List<Char>> {
    if ( size < 0 || size % 2 == 0) return emptyList()

    val start = 0
    val xList = ArrayList<List<Char>>()
    for (row in start until size) {
        val xCellList = ArrayList<Char>()
        for (cell in start until size) {
            if (row == cell || row + cell == size - 1) {
                xCellList.add('X')
            } else {
                xCellList.add(' ')
            }
        }
        xList.add(xCellList)
    }
    return xList
}

fun main() {
    draw(ELEVEN)
}
