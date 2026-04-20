package ru.job4j.dsl.infix

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

infix fun Any?.eq(other: Any?) = assertEquals(other, this)
infix fun Any?.notEq(other: Any?) = assertNotEquals(other, this)
infix fun <T> Iterable<T>.contains(elements: Collection<T>) {
    val list = this.toList()
    assertTrue(list.containsAll(elements))
}

class JUnitInfixKtTest {
    @Test
    fun whenIntEqThenTrue() {
        1 eq 1
    }

    @Test
    fun whenStringEqThenTrue() {
        "String" eq "String"
    }

    @Test
    fun whenIntNotEqThenTrue() {
        1 notEq 2
    }

    @Test
    fun whenStringNotEqThenTrue() {
        "String" notEq "string"
    }

    @Test
    fun whenListContainsListThenTrue() {
        listOf(1, 2, 3) contains listOf(1, 2)
    }

    @Test
    fun whenListContainsSetThenTrue() {
        listOf(1, 2, 3) contains setOf(1, 2)
    }
}
