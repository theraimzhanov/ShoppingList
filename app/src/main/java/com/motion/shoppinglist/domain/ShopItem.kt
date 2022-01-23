package com.motion.shoppinglist.domain

data class ShopItem(val name:String,
                    val count:Int ,
                    val enabled:Boolean,
                    var id:Int = UNINSTALL_ID)
{
    companion object{
        const val UNINSTALL_ID = -99
    }
}
