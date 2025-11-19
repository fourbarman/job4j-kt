package ru.job4j.base

private const val SIX = 6
private const val TWO = 2

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

    val plus = add(SIX, TWO)
    println("$SIX + $TWO = $plus")

    val minus = substruct(SIX, TWO)
    println("$SIX - $TWO = $minus")

    val multiply = multiplication(SIX, TWO)
    println("$SIX * $TWO = $multiply")

    val divide = division(SIX, TWO)
    println("$SIX / $TWO = $divide")
}
