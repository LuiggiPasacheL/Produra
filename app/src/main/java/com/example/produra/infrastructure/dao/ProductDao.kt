package com.example.produra.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.produra.model.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(p: Product)
    @Update
    suspend fun updateProduct(p: Product)
    @Query("SELECT * FROM products WHERE name = :name")
    suspend fun getProductByName(name: String): Product?
    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<Product>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Int): Product?
}