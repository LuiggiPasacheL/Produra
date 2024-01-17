package com.example.produra.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.produra.infrastructure.entities.ProductEntity

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(p: ProductEntity)
    @Update
    suspend fun updateProduct(p: ProductEntity)
    @Query("SELECT * FROM products WHERE name = :name")
    suspend fun getProductByName(name: String): ProductEntity?
    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Int): ProductEntity?
}