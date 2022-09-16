package com.tom.shop.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("select * from Product")
    fun getAll():List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product:Product)

}