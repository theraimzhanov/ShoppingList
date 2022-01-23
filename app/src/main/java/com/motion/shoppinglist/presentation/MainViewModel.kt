package com.motion.shoppinglist.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motion.shoppinglist.data.ShopListRepositoryImpl
import com.motion.shoppinglist.domain.DeleteShopItemUseCase
import com.motion.shoppinglist.domain.EditShopItemUseCase
import com.motion.shoppinglist.domain.GetShopListUseCase
import com.motion.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }
    fun changeEnabledState(shopItem: ShopItem){
        val item = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(item)
        getShopList()
    }
}