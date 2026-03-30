package ru.job4j.safe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BankServiceTest() {
    @Test
    fun whenTransferAndBankHasUserAndAccountThenShouldReturnTrue() {
        val fromUser = User("111", "John")
        val fromAccount = Account("11111-11111-11111", 100.0)

        val toUser = User("222", "Alice")
        val toAccount = Account("22222-22222-22222", 50.0)

        val bankService = BankService()

        bankService.addUser(fromUser)
        bankService.addUser(toUser)

        bankService.addAccount(fromUser.passport, fromAccount)
        bankService.addAccount(toUser.passport, toAccount)

        assertThat(bankService.transferMoney(
            fromUser.passport, fromAccount.requisite,
            toUser.passport, toAccount.requisite,
            50.0))
            .isEqualTo(true)
    }

    @Test
    fun whenTransferAndBankHasNoUserAndAccountThenShouldReturnFalse() {
        val fromUser = User("111", "John")
        val fromAccount = Account("11111-11111-11111", 100.0)

        val bankService = BankService()

        bankService.addUser(fromUser)

        bankService.addAccount(fromUser.passport, fromAccount)

        assertThat(bankService.transferMoney(
            fromUser.passport, fromAccount.requisite,
            "no passport", "no account",
            50.0))
            .isEqualTo(false)
    }
}
