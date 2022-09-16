package com.tom.shop.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Product::class), version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

}