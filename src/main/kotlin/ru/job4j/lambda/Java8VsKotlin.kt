package ru.job4j.lambda

fun main() {
    val max = {x: Int, y: Int -> if (x > y) x else y}
    val result = max(3, 4)
    println("Max: $result")

    val inc = {x: Int -> x + 1}
    println("Increment: ${inc(1)}")

    //Decrement
    val dec = {x: Int -> x - 1}
    println("Decrement: ${dec(2)}")

    //Square
    val square = {x: Int -> x * x}
    println("Square: ${square(3)}")
}
