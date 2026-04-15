package ru.job4j.dsl

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

data class Item(var id: Long, var name: String)

interface Store {
    fun openConnection(): Connection
}

class ItemStore(
    private val url: String,
    private val username: String,
    private val password: String
) : Store {

    override fun openConnection(): Connection {
        return DriverManager.getConnection(url, username, password)
    }
}

fun <T> ItemStore.tx(block: Connection.() -> T): T {
    openConnection().use { connection ->
        return connection.block()
    }
}

fun ItemStore.save(item: Item): Item {
    return tx {
        prepareStatement(
            "INSERT INTO items (name) VALUES (?)",
            Statement.RETURN_GENERATED_KEYS
        ).use { preparedStatement ->
            preparedStatement.setString(1, item.name)
            preparedStatement.executeUpdate()

            preparedStatement.generatedKeys.use { generatedKeys ->
                if (generatedKeys.next()) {
                    item.copy(id = generatedKeys.getLong(1))
                } else {
                    item
                }
            }
        }
    }
}

fun ItemStore.findById(id: Long): Item? {
    return tx {
        prepareStatement(
            "SELECT id, name FROM items WHERE id = ?"
        ).use { preparedStatement ->
            preparedStatement.setLong(1, id)
            preparedStatement.executeQuery().use { resultSet ->
                if (resultSet.next()) {
                    Item(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                    )
                } else {
                    null
                }
            }
        }
    }
}

fun ItemStore.findAll(): List<Item> {
    return tx {
        val foundItems = mutableListOf<Item>()
        prepareStatement("SELECT id, name FROM items").use { preparedStatement ->
            preparedStatement.executeQuery().use { resultSet ->
                while (resultSet.next()) {
                    foundItems.add(
                        Item(
                            resultSet.getLong("id"),
                            resultSet.getString("name")
                        )
                    )
                }
            }
            foundItems
        }
    }
}

fun ItemStore.update(item: Item): Boolean {
    return tx {
        prepareStatement("UPDATE items SET name = ? WHERE id = ?")
            .use { preparedStatement ->
                preparedStatement.setString(1, item.name)
                preparedStatement.setLong(2, item.id)
                preparedStatement.executeUpdate() > 0
            }
    }
}

fun ItemStore.delete(id: Long): Boolean {
    return tx {
        prepareStatement("DELETE FROM items WHERE id = ?")
            .use { preparedStatement ->
                preparedStatement.setLong(1, id)
                preparedStatement.executeUpdate() > 0
            }
    }
}