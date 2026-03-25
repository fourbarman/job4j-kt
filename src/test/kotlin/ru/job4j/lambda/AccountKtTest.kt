package ru.job4j.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountKtTest {

    @Test
    fun whenFilterEmptyListThenReturnEmptyList() {
        val accounts = listOf<Account>()
        assertThat(filterAccounts(accounts)).isEmpty()
    }

    @Test
    fun whenFilterAccountsThenReturnAccounts() {
        val accounts = listOf<Account>(
            Account("Ivan", 10)
        )
        assertThat(filterAccounts(accounts)).containsExactly(Account("Ivan", 10))
    }

    @Test
    fun whenFilterAccountsWithNoConditionByNameThenReturnEmptyList() {
        val accounts = listOf<Account>(
            Account("Alice", 10)
        )
        assertThat(filterAccounts(accounts)).isEmpty()
    }

    @Test
    fun whenFilterAccountsWithNoConditionByBalanceThenReturnEmptyList() {
        val accounts = listOf<Account>(
            Account("Ivan", 0)
        )
        assertThat(filterAccounts(accounts)).isEmpty()
    }

    @Test
    fun whenFilterAccountsWithConditionThenReturnAccounts() {
        val accounts = listOf<Account>(
            Account("Ivan", 2),
            Account("Alice", 50),
            Account("Ivan", 40),
            Account("Alice", 0),
            Account("Ivan", 0),
            Account("Ivan", 100),
        )
        assertThat(filterAccounts(accounts))
            .containsExactlyInAnyOrder(
                Account("Ivan", 2),
                Account("Ivan", 40),
                Account("Ivan", 100),
            )
    }
}
