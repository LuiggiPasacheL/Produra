package com.example.produra.presentation.productList

import com.example.produra.model.Product

data class ProductListState(
    val products: List<Product> = listOf(
        Product(1, "Plátano", "Color amarillo", 1, 12, "mano"),
        Product(2, "Banana", "Tulepera con la banana", 1, 20, "hand"),
        Product(3, "Manzana", "Manzana", 1, 10, "unidades")
    )
)
