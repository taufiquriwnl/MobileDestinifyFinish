package com.example.tour_guide

object ShoppingCart {
    private val items: MutableMap<String, ShoppingCartItem> = mutableMapOf()

    fun addItem(itemKey: String, item: ShoppingCartItem) {
        items[itemKey] = item
    }

    fun addItem(item: ShoppingCartItem) {
        items[item.itemName] = item
    }

    fun getItems(): List<ShoppingCartItem> {
        return items.values.toList()
    }

    fun getTotalPrice(): Double {
        return items.values.sumByDouble { it.itemPrice }
    }

    fun removeItemsByType(itemType: String) {
        items.values.removeAll { it.itemType == itemType }
    }
}
