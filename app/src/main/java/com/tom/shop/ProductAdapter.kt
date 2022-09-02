package com.tom.shop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.cow_product, parent, false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.title.text = products[position].title
        holder.price.text = products[position].price.toString()
        holder.desc.text = products[position].description
    }

    override fun getItemCount(): Int {
        return products.size
    }
}

class ProductViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val title: TextView = item.findViewById(R.id.product_title)
    val price: TextView = item.findViewById(R.id.product_price)
    val desc: TextView = item.findViewById(R.id.product_desc)

}