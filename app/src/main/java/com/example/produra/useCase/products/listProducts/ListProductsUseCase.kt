package com.example.produra.useCase.products.listProducts

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class ListProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): List<Product> = productRepository.getAll()
}
