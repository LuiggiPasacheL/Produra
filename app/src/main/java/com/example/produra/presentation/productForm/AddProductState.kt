package com.example.produra.presentation.productForm

import com.example.produra.model.Product

data class AddProductState(
    val product: Product = Product(
        id = null,
        name = "",
        description = "",
        mustBePurchased = false,
    ),
    val editable: Boolean = false,
)