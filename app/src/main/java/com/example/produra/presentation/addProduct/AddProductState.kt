package com.example.produra.presentation.addProduct

import com.example.produra.model.Product

data class AddProductState(
    val name: String = "",
    val description: String = "",
    val minQuantity: Number = 1,
    val quantity: Number = 0,
    val units: String = ""
) {
    fun toProduct(): Product {
        return Product(
            id = null,
            name = name,
            description = description,
            minQuantity = minQuantity,
            quantity = quantity,
            units = units
        )
    }

    fun fromProduct(p: Product): AddProductState {
        return this.copy(
            name = p.name,
            description = p.description,
            minQuantity = p.minQuantity,
            quantity = p.quantity,
            units = p.units
        )
    }
}