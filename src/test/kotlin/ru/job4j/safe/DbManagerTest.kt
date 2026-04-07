package ru.job4j.safe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DbManagerTest {
    private lateinit var dbManager: DbManager

    @BeforeEach
    fun setUp() {
        dbManager = DbManager()
        dbManager.init()
        dbManager.exec("DELETE FROM users")
        dbManager.exec("INSERT INTO users VALUES (1, 'IVAN'), (2, 'MARIA')")
    }

    @Test
    fun whenInsertThenShouldReturnInsertedCount() {
        val insert = "INSERT INTO users VALUES (3, 'ALICE'), (4, 'KARL')"
        assertThat(dbManager.exec(insert)).isEqualTo("INSERT success: 2 rows affected")
    }

    @Test
    fun whenUpdateAndNothingToUpdateThenShouldReturnZeroRowsAffected() {
        val update = "UPDATE users SET name = 'Petr' WHERE id = 7"
        assertThat(dbManager.exec(update)).isEqualTo("UPDATE success: 0 rows affected")
    }

    @Test
    fun whenUpdateThenShouldReturnRowsAffected() {
        val update = "UPDATE users SET name = 'Petr' WHERE id = 1"
        assertThat(dbManager.exec(update)).isEqualTo("UPDATE success: 1 rows affected")
    }

    @Test
    fun whenSelectAllThenShouldReturnRowsAffected() {
        val update = "SELECT * FROM users"
        assertThat(dbManager.exec(update)).isEqualTo("SELECT success: 2 rows found")
    }

    @Test
    fun whenSelectByNameThenShouldReturnRowsAffected() {
        val update = "SELECT * FROM users WHERE name = 'MARIA'"
        assertThat(dbManager.exec(update)).isEqualTo("SELECT success: 1 rows found")
    }

    @Test
    fun whenDeleteThenShouldReturnRowsAffected() {
        val delete = "DELETE FROM users WHERE id = 2"
        assertThat(dbManager.exec(delete)).isEqualTo("DELETE success: 1 rows affected")
    }
}