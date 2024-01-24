package com.example.produra.useCase.products.addOrUpdateProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class AddOrUpdateProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(p: Product) {
        return productRepository.save(p)
    }
}