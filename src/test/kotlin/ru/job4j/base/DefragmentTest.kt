package ru.job4j.base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefragmentTest {
    @Test
    fun whenDefragmentArrayWithNoElements() {
        val strings = arrayOfNulls<String>(10)
        val rls = defragment(strings)
        assertThat(rls).containsSequence(null, null, null, null, null, null, null, null, null, null)
    }

    @Test
    fun whenDefragmentArrayWithOneFirstElement() {
        val strings = arrayOfNulls<String>(10)
        strings[0] = "String0"
        val rls = defragment(strings)
        assertThat(rls).contains("String0")
        assertThat(rls).containsSequence("String0", null, null, null, null, null, null, null, null, null)
    }

    @Test
    fun whenDefragmentArrayWithOneSecondElement() {
        val strings = arrayOfNulls<String>(10)
        strings[1] = "String1"
        val rls = defragment(strings)
        assertThat(rls).contains("String1")
        assertThat(rls).containsSequence("String1", null, null, null, null, null, null, null, null, null)
    }

    @Test
    fun whenDefragmentArrayWithTwoElementsAtBeginAndEnd() {
        val strings = arrayOfNulls<String>(10)
        strings[0] = "String0"
        strings[9] = "String9"
        val rls = defragment(strings)
        assertThat(rls).contains("String0", "String9")
        assertThat(rls).containsSequence("String0", "String9", null, null, null, null, null, null, null, null)
    }

    @Test
    fun whenDefragmentArray() {
        val strings = arrayOfNulls<String>(10)
        strings[1] = "String1"
        strings[3] = "String3"
        strings[5] = "String5"
        strings[7] = "String7"
        val rls = defragment(strings)
        assertThat(rls).contains("String1", "String3", "String5", "String7")
        assertThat(rls).containsSequence("String1", "String3", "String5", "String7", null, null, null, null, null, null)
    }

    @Test
    fun whenDefragmentArrayWithElementsInTheEnd() {
        val strings = arrayOfNulls<String>(10)
        strings[7] = "String7"
        strings[8] = "String8"
        strings[9] = "String9"
        val rls = defragment(strings)
        assertThat(rls).contains("String7", "String8", "String9")
        assertThat(rls).containsSequence("String7", "String8", "String9", null, null, null, null, null, null, null)
    }
}