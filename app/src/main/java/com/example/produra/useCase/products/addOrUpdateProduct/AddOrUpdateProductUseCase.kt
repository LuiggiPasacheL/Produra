package com.example.produra.useCase.products.addOrUpdateProduct

import com.example.produra.model.Product
import com.example.produra.useCase.products.ProductRepository
import javax.inject.Inject

class AddOrUpdateProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(p: Product) {
        if (p.unit?.unitId != null) {
            // TODO: Null pointer exception
            // TODO: EDIT UNIT ON SAVE
            return productRepository.save(p, p.unit.unitId)
        } else {
            throw Error("El producto no tiene una unidad válida")
        }
    }
}