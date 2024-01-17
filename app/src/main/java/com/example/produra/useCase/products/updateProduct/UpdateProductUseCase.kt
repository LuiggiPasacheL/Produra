package com.example.produra.useCase.products.updateProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class UpdateProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(p: Product) {
        productRepository.save(p)
    }
}
