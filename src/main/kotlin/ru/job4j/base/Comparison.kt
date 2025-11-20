package ru.job4j.base

private const val THREE = 3
private const val SIX = 6
private const val EIGHT = 8

fun max(first: Int, second: Int): Int = if (first > second) first else second

fun max(first: Int, second: Int, third: Int): Int = max(max(first, second), third)


fun main() {
    val maxTwo = max(THREE, SIX)
    val maxThree = max(THREE, SIX, EIGHT)
    println("max from $THREE and $SIX is $maxTwo")
    println("max from $THREE and $SIX and $EIGHT is $maxThree")

}
