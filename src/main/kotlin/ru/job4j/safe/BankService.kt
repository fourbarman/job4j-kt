package ru.job4j.safe

class BankService {
    private val users = mutableMapOf<User, MutableList<Account>>()

    fun addUser(user: User) {
        users.putIfAbsent(user, mutableListOf())
    }

    fun addAccount(passport: String, account: Account) {
        val user = findByPassport(passport) ?: return
        users[user]?.add(account)
    }

    fun findByPassport(passport: String): User? {
        return users.keys.firstOrNull { it.passport == passport }
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport)
        return users[user]?.find { it.requisite == requisite }
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, destRequisite: String,
        amount: Double
    ): Boolean {

        val source = findByRequisite(srcPassport, srcRequisite) ?: return false
        val dest = findByRequisite(destPassport, destRequisite) ?: return false
        source.balance -= amount
        dest.balance += amount
        return true
    }
}

data class User(val passport: String, val name: String)

data class Account(val requisite: String, var balance: Double)
