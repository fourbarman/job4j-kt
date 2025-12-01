package ru.job4j.base

/* Draw X. size > 0 и нечетное */
fun draw(size: Int): List<List<Char>> {
    if (size < 0 || size % 2 ==0) {
        return emptyList()
    }

    val rows = ArrayList<ArrayList<Char>>()
    var index = 0

    while (index < size * size) {
        val row = index / size
        val cell = index % size

        if (rows.size <= row) {
            rows.add(ArrayList())
        }

        val rowCells = rows[row]

        if (row == cell || row + cell == size -1) {
            rowCells.add('X')
        } else {
            rowCells.add(' ')
        }
        index++
    }
    return rows
}
