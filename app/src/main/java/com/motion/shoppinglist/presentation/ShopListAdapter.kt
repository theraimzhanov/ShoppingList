package com.motion.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.motion.shoppinglist.R
import com.motion.shoppinglist.domain.ShopItem

class ShopListAdapter:ListAdapter<ShopItem,ShopListAdapter.ShopListViewHolder>(ShopItemCallBack()) {

 /*   var shopList = listOf<ShopItem>()
        set(value) {
            val callBack = ShopListDiffCallBack(shopList,value)
            val diffResult = DiffUtil.calculateDiff(callBack)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layout = when (viewType) {
            COUNT_DISABLED -> R.layout.shop_item_disabled
            COUNT_ENABLED -> R.layout.shop_item_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.itemView.setOnLongClickListener {
            true
        }

        holder.textViewName.text = shopItem.name
        holder.textViewCount.text = shopItem.count.toString()
    }

   /* override fun onViewRecycled(holder: ShopListViewHolder) {
        super.onViewRecycled(holder)
        holder.textViewName.text = ""
        holder.textViewCount.text = ""
        holder.textViewName.setTextColor(
            ContextCompat.getColor(
                holder.itemView.context,
                android.R.color.white
            )
        )
    }*/

   /* override fun getItemCount(): Int {
       return shopList.size
    }*/

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            COUNT_ENABLED
        } else {
            COUNT_DISABLED
        }
    }

    class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.nameOfItem)
        val textViewCount = itemView.findViewById<TextView>(R.id.countOfItem)
}
    companion object {

        const val COUNT_ENABLED = 100
        const val COUNT_DISABLED = 101

        const val MAX_POOL_SIZE = 30
    }
}