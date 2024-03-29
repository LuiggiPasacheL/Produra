package com.example.produra.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.infrastructure.entities.ProductWithUnit

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(p: ProductEntity)

    @Update
    suspend fun updateProduct(p: ProductEntity)

    @Transaction
    @Query("SELECT * FROM products")
    suspend fun getProductsWithUnit(): List<ProductWithUnit>

    @Transaction
    @Query("SELECT * FROM products WHERE mustBePurchased=1")
    suspend fun getProductsWithUnitMustBePurchased(): List<ProductWithUnit>

    @Transaction
    @Query("SELECT * FROM products WHERE name = :productName")
    suspend fun getProductWithUnitByName(productName: String): ProductWithUnit?

    @Transaction
    @Query("SELECT * FROM products WHERE productId = :productId")
    suspend fun getProductWithUnit(productId: Int): ProductWithUnit?
}