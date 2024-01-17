package com.example.produra.useCase.products.addProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    @Throws(ProductNameExistsException::class)
    suspend operator fun invoke(p: Product) {
        val product = productRepository.getByName(p.name)
        if (product != null) throw ProductNameExistsException()
        return productRepository.save(p)
    }
}