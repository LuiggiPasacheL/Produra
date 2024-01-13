package com.example.produra.useCase.products.getProducts

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> = productRepository.getAll()
}
