package com.example.produra.useCase.products.addProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository

class AddProductUseCase(
    private val repository: ProductRepository
) {
    @Throws(ProductNameExistsException::class)
    suspend operator fun invoke(p: Product) {
        val product = repository.getProductByName(p.name)
        if (product != null) throw ProductNameExistsException()
        return repository.addProduct(p)
    }
}