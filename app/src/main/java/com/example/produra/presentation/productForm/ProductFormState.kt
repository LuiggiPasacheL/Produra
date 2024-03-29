package com.example.produra.presentation.productForm

import com.example.produra.model.PUnit
import com.example.produra.model.Product

data class ProductFormState(
    val name: String = "",
    val description: String = "",
    val quantity: String = "",
    val selectedUnit: PUnit? = null,
    val mustBePurchased: Boolean = false,

    val units: List<PUnit> = listOf(PUnit.createEmpty()),
)