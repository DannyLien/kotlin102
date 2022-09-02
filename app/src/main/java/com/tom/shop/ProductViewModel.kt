package com.tom.shop

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import kotlin.concurrent.thread

class ProductViewModel : ViewModel() {

    val products = MutableLiveData<List<Product>>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val json = URL("https://fakestoreapi.com/products").readText()
            val productList = Gson().fromJson<List<Product>>(
                json,
                object : TypeToken<List<Product>>() {}.type
            )
            products.postValue(productList)
        }
    }

}

data class Product(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val image: String
)


