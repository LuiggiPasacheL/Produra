package com.example.produra.useCase.products.getProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository

class GetProductUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Product? = repository.getProductById(id)
}