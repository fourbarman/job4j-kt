package ru.job4j.lambda

import kotlin.math.pow

fun operation(type: String): (Double, Double) -> Double {
    val add: (Double, Double) -> Double = { a, b -> a + b }
    val subtract: (Double, Double) -> Double = { a, b -> a - b }
    val multiply: (Double, Double) -> Double = { a, b -> a * b }
    val divide: (Double, Double) -> Double = { a, b -> a / b }
    val power: (Double, Double) -> Double = { a, b -> a.pow(b) }
    val unknown: (Double, Double) -> Double = { a, b -> Double.NaN }

    return when (type) {
        "add" -> add
        "subtract" -> subtract
        "multiply" -> multiply
        "divide" -> divide
        "power" -> power
        else -> unknown
    }
}
