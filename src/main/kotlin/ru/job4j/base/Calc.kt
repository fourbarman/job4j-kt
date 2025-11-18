package ru.job4j.base

fun add(first: Int, second: Int): Int {
    return first + second
}

fun substruct(first: Int, second: Int): Int {
    return first - second
}

fun multiplication(first: Int, second: Int): Int {
    return first * second
}

fun division(first: Int, second: Int): Int {
    return first / second
}

fun main() {
    val a = 6
    val b = 2

    val plus = add(a, b)
    println("$a + $b = $plus")

    val minus = substruct(a, b)
    println("$a - $b = $minus")

    val multiply = multiplication(a, b)
    println("$a * $b = $multiply")

    val divide = division(a, b)
    println("$a / $b = $divide")
}