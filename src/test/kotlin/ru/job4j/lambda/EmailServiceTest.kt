package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmailServiceTest() {
    @Test
    fun testEmailService() {
        val emailService = EmailService()
        val expected = "Subject : email@email.comBody : Hello, User You win!"

        assertThat(emailService.emailToWith(Message("User", "email@email.com"))).isEqualTo(expected)
    }
}
