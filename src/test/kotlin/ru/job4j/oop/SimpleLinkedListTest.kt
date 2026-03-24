package ru.job4j.oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SimpleLinkedListTest {

    @Test
    fun whenAddThenListHasThatValue() {
        val list = SimpleLinkedList<String>()

        list.add("1")
        list.add("2")

        assertThat(list).containsExactlyInAnyOrder("1", "2")
    }

    @Test
    fun whenEmptyListThenSizeIsZero() {
        val list = SimpleLinkedList<String>()

        assertThat(list.size()).isEqualTo(0)
    }

    @Test
    fun whenAddTwoElementsToListThenListSizeIsTwo() {
        val list = SimpleLinkedList<String>()

        list.add("1")
        list.add("2")

        assertThat(list.size()).isEqualTo(2)
    }

    @Test
    fun whenRemoveFirstThenFirstRemoved() {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.add("3")

        val removed = list.removeFirst()

        assertThat(removed).isEqualTo("3")
        assertThat(list.size()).isEqualTo(2)
        assertThat(list).containsExactlyInAnyOrder("1", "2")
    }

    @Test
    fun whenRemoveFirstAndListIsEmptyThenThrowNoSuchElementException() {
        val list = SimpleLinkedList<String>()

        assertThrows(NoSuchElementException()::class.java) {
            list.removeFirst()
        }
    }

    @Test
    fun whenGetThenReturnElement() {
        val list = SimpleLinkedList<String>()

        list.add("1")
        list.add("2")
        list.add("3")

        val result = list.get(1)

        assertThat(result).isEqualTo("2")
    }

    @Test
    fun whenGetAndListIsEmptyThenThrowIndexOutOfBoundsException() {
        val list = SimpleLinkedList<String>()

        assertThrows(IndexOutOfBoundsException::class.java) {
            list.get(1)
        }
    }

    @Test
    fun whenGetOutOfBoundsIndexAndListIsEmptyThenThrowIndexOutOfBoundsException() {
        val list = SimpleLinkedList<String>()

        list.add("1")
        list.add("2")
        list.add("3")

        assertThrows(IndexOutOfBoundsException::class.java) {
            list.get(3)
        }
    }

    @Test
    fun whenIteratorOnEmptyListTheHasNextIsFalse() {
        val list = SimpleLinkedList<String>()
        val iterator = list.iterator()

        assertThat(iterator.hasNext()).isFalse()
    }

    @Test
    fun whenIteratorHasOneElementThenReturnIt() {
        val list = SimpleLinkedList<String>()
        list.add("1")

        val it = list.iterator()

        assertThat(it.hasNext()).isTrue()
        assertThat(it.next()).isEqualTo("1")
        assertThat(it.hasNext()).isFalse()
    }

    @Test
    fun whenIteratorHasSeveralElementsThenReturnThemInListOrder() {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.add("3")

        val it = list.iterator()

        assertThat(it.next()).isEqualTo("3")
        assertThat(it.next()).isEqualTo("2")
        assertThat(it.next()).isEqualTo("1")
        assertThat(it.hasNext()).isFalse()
    }

    @Test
    fun whenNextOnEmptyListThenThrowNoSuchElementException() {
        val list = SimpleLinkedList<String>()
        val it = list.iterator()

        assertThrows(NoSuchElementException::class.java) {
            it.next()
        }
    }

    @Test
    fun whenNextAfterLastElementThenThrowNoSuchElementException() {
        val list = SimpleLinkedList<String>()
        list.add("1")

        val it = list.iterator()
        it.next()

        assertThrows(NoSuchElementException::class.java) {
            it.next()
        }
    }

    @Test
    fun whenUseForLoopThenIterateAllElements() {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.add("3")

        val result = mutableListOf<String>()
        for (value in list) {
            result.add(value)
        }

        assertThat(result).containsExactlyInAnyOrder("1", "2", "3")
    }
}
