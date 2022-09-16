package com.tom.shop.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    val id: Int,
//    @ColumnInfo(name="title")  //title名稱相同無必要
    val title: String,
    val price: Float,
    val description: String,
    @ColumnInfo(name = "image_url")  // image 的欄位可以改變
    val image: String

)