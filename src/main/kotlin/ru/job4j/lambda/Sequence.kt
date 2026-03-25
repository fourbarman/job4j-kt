package ru.job4j.lambda

fun count(list: List<Int>): Int {
    return list
        .asSequence()
        .filter { it % 2 == 0 }
        .map {it + 1}
        .sum()
}
