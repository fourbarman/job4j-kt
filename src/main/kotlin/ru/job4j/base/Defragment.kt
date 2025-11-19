package ru.job4j.base

fun defragment(array: Array<String?>): Array<String?> {
    var write = 0

    for (value in array) {
        if (value != null) {
            array[write] = value
            write++
        }
    }

    while (write < array.size) {
        array[write] = null
        write++
    }
    return array
}
