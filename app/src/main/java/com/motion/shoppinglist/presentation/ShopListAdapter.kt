package com.motion.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.motion.shoppinglist.R
import com.motion.shoppinglist.domain.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

val list = listOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item_disabled,parent,false)
     return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
      val shopItem = list[position]
        holder.textViewName.text = shopItem.name
        holder.textViewCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            true
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }


    class ShopItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val textViewName = itemView.findViewById<TextView>(R.id.nameOfItem)
        val textViewCount = itemView.findViewById<TextView>(R.id.countOfItem)
    }
}