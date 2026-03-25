package ru.job4j.lambda

class EmailService {
    fun emailToWith(message: Message): String {
        return with(StringBuilder()) {
            append("Subject : ").append(message.email)
            append("Body : ").append("Hello, ").append(message.username).append(" ")
            append("You win!")
        }.toString()
    }
}

data class Message(val username: String, val email: String)
