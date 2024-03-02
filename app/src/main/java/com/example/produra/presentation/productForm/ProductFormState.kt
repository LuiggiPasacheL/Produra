package com.example.produra.presentation.productForm

import com.example.produra.model.PUnit
import com.example.produra.model.Product

data class ProductFormState(
    val product: Product = Product.createEmpty(),
    val units: List<PUnit> = listOf(PUnit.createEmpty()),
    val editable: Boolean = false,
)