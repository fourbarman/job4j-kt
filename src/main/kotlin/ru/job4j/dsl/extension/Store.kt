package ru.job4j.dsl.extension

interface Store<T> {
    fun save(model: T): T
}

class Item

class ItemStore: Store<Item> {
    override fun save(model: Item): Item {
        println("Item saved to Item Store")
        return model
    }
}

val itemStore = ItemStore()

fun Item.save(): Item {
    return itemStore.save(this)
}

fun main() {
    val itemStore = ItemStore()
    itemStore.save(Item())

    val item = Item()
    item.save()
}