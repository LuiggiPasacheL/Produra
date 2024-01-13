package com.example.produra.useCase.products.getProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository

class GetProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Product? = productRepository.getById(id)
}