package com.example.produra.useCase.products

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.produra.model.Product

@Dao
interface ProductRepository {
    @Insert
    suspend fun addProduct(p: Product)
    @Query("SELECT * FROM products WHERE name = :name")
    suspend fun getProductByName(name: String): Product?
    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<Product>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: Int): Product?
}