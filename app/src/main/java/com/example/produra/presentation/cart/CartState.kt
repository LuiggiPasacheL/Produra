package com.example.produra.presentation.cart

import com.example.produra.model.Product

data class CartState (
    val products: List<Product> = listOf(),
    val takeOutCart: Boolean = false
)