package com.example.produra.useCase.products

import com.example.produra.model.Product

interface ProductRepository {
    suspend fun save(p: Product)
    suspend fun getById(id: Int): Product?
    suspend fun getByName(name: String): Product?
    suspend fun getAll(): List<Product>
    suspend fun getCart(): List<Product>
}