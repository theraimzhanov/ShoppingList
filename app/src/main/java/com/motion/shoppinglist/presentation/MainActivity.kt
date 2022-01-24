package com.motion.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.motion.shoppinglist.R
import com.motion.shoppinglist.domain.ShopItem
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapterShopList: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            adapterShopList.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        val recyclerViewShopList = findViewById<RecyclerView>(R.id.recyclerViewListShopping)
        with(recyclerViewShopList) {
            adapterShopList = ShopListAdapter()
            adapter = adapter
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.COUNT_ENABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.COUNT_DISABLED,
                ShopListAdapter.MAX_POOL_SIZE
            )
        }
    }
}
