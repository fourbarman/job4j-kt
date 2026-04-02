package ru.job4j.oop

import kotlin.NoSuchElementException

class SimpleLinkedList<T> : Iterable<T> {
    private var size = 0
    private var head: Node<T>? = null

    fun add(value: T) {
        head = Node<T>(value, head)
        size++
    }

    fun get(index: Int): T {
        if (index < 0 || index >= size) throw IndexOutOfBoundsException("Index: $index, Size: $size")
        var count = 0
        var current = head
        while (count != index) {
            current = current?.next
            count++
        }
        return current!!.value
    }

    fun size(): Int = size

    fun removeFirst(): T {
        val first = head ?: throw NoSuchElementException()
        head = first.next
        size--
        return first.value
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T> {
        private var current = head

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            val value = current!!.value
            current = current!!.next
            return value
        }
    }

    fun listIterator(): ListIterator<T> = SimpleLinkedListIterator()

    inner class SimpleLinkedListIterator : ListIterator<T> {
        private var cursor = 0


        override fun hasNext(): Boolean {
            return cursor < size
        }

        override fun hasPrevious(): Boolean {
            return cursor > 0
        }

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return get(cursor++)
        }

        override fun nextIndex(): Int {
            return cursor
        }

        override fun previous(): T {
            if (!hasPrevious()) throw NoSuchElementException()
            cursor--
            return get(cursor)
        }

        override fun previousIndex(): Int {
            return cursor - 1
        }

    }

    class Node<K>(val value: K, var next: Node<K>? = null)
}
