package com.example.produra.presentation.productList

import com.example.produra.model.Product

data class ProductListState(
    val products: List<Product> = listOf(),
    val productChanged: Boolean = false
)
