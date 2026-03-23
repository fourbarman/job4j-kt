package ru.job4j.oop

class Student(
    var name: String,
    var surname: String,
    var phone: String,
    var email: String
) {
    constructor(name: String, surname: String, phone: String) : this(name, surname, phone, "")
    constructor(name: String, surname: String) : this(name, surname, "phone", "")
    constructor(name: String) : this(name, "", "", "")

    fun show() {
        println("$name $email $surname $phone")
    }
}

fun main() {
    Student("Ivan", "Ivanov", "890000000", "ivan@mail.com").show()
    Student("Ivan", "Ivanov", "890000000").show()
    Student("Ivan", "Ivanov").show()
    Student("Ivan").show()
}
