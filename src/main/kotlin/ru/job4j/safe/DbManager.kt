package ru.job4j.safe

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class DbManager() {
    private lateinit var connection: Connection

    fun init() {
        val url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"
        connection = DriverManager.getConnection(url)

        exec("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))")
    }

    fun exec(sql: String): String {
        return try {
            val statement = connection.createStatement()
            val hasResultSet = statement.execute(sql)
            val operation = sql.trim().split(" ")[0].uppercase()

            if (hasResultSet) {
                val rs = statement.resultSet
                val count = countRows(rs)
                "$operation success: $count rows found"
            } else {
                val updateCount = statement.updateCount
                "$operation success: $updateCount rows affected"
            }
        } catch (e: Exception) {
            "Error executing query: ${e.message}"
        }
    }

    private fun countRows(resultSet: ResultSet): Int {
        var count = 0
        while (resultSet.next()) count++
        return count
    }
}
