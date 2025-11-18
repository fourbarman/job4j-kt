package ru.job4j.base

fun max(first: Int, second: Int): Int = if (first > second) first else second

fun max(first: Int, second: Int, third: Int): Int =
    if (max(first, second) < third) third else max(first, second)


fun main() {
    val a = 3
    val b = 6
    val c = 8
    val maxTwo = max(a, b)
    val maxThree = max(a, b, c)
    println("max from $a and $b is $maxTwo")
    println("max from $a and $b and $c is $maxThree")

}