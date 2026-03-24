package ru.job4j.oop

open class Profession(
    var name: String,
    var experience: Int
)

class ITManager(
    name: String,
    experience: Int
) : Profession(name, experience)

class Lawyer(
    name: String,
    experience: Int
) : Profession(name, experience)

class Teacher(
    name: String,
    experience: Int
) : Profession(name, experience)
