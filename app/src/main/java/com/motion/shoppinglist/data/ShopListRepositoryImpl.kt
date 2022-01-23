package com.motion.shoppinglist.data

import com.motion.shoppinglist.domain.ShopItem
import com.motion.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var generateId = 0

    init {
        for(i in 0 until 10){
            val item = ShopItem("ShopItem_$i",i,true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNINSTALL_ID){
        shopItem.id = generateId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val firstItem = getShopItem(shopItem.id)
        shopList.remove(firstItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }
            ?: throw RuntimeException("No found item by ID :$shopItemId")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}