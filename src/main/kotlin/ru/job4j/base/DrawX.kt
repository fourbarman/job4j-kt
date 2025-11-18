package ru.job4j.base

/* Draw X. size > 0 и нечетное */
fun draw(size: Int) {
    val start = 0
    for (value in start until size) {
        for (value2 in start until size) {
            if (value == value2 || value + value2 == size - 1) {
                print("X")
            } else {
                print(" ")
            }
        }
        println()
    }
}

fun main() {
    draw(11)
}