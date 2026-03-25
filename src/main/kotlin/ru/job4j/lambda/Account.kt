package ru.job4j.lambda

data class Account(val name: String, val balance: Int)

fun filterAccounts(accounts: List<Account>): List<Account> {
    return accounts.filter { it.name == "Ivan" && it.balance > 0 }
}
