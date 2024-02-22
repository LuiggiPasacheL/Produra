package com.example.produra.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.infrastructure.entities.ProductWithUnit
import com.example.produra.infrastructure.entities.UnitWithProducts

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(p: ProductEntity)

    @Update
    suspend fun updateProduct(p: ProductEntity)

    @Query("SELECT * FROM products WHERE name = :name")
    suspend fun getProductByName(name: String): ProductEntity?

    @Query("SELECT * FROM products WHERE productId = :id")
    suspend fun getProductById(id: Int): ProductEntity?

    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE mustBePurchased=1")
    suspend fun getMustBePurchasedProducts(): List<ProductEntity>

    @Transaction
    @Query(
        """
        SELECT * FROM products
    """
    )
    suspend fun getProductsWithUnit(): List<ProductWithUnit>

    @Transaction
    @Query(
        """
        SELECT * FROM products
        WHERE productId = :productId
    """
    )
    suspend fun getProductsWithUnit(productId: Int): ProductWithUnit?
}