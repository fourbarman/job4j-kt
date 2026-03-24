package ru.job4j.oop

open class Profession(
    var name: String,
    var experience: Int
) {
    open fun action() {
        println("$name with $experience years of experience makes action")
    }
}

class ITManager(
    name: String,
    experience: Int
) : Profession(name, experience) {

    override fun action() {
        println("$name with $experience years of experience makes IT")
    }
}

class Lawyer(
    name: String,
    experience: Int
) : Profession(name, experience) {

    override fun action() {
        println("$name with $experience years of experience read laws")
    }
}

class Teacher(
    name: String,
    experience: Int
) : Profession(name, experience) {

    override fun action() {
        println("$name with $experience years of experience is teaching")
    }
}
