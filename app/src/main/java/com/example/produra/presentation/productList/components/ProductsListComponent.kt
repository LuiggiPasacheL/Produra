package com.example.produra.presentation.productList.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.produra.model.Product

@Composable
fun ProductListComponent(
    products: List<Product>,
    decreaseProductQuantity: (Product) -> Unit,
    increaseProductQuantity: (Product) -> Unit
) {
    LazyColumn {
        items(products) { product ->
            ProductCard(
                product = product, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
                decreaseProductQuantity = decreaseProductQuantity,
                increaseProductQuantity = increaseProductQuantity
            )
        }
    }
}

@Preview
@Composable
fun ProductListComponentPreview() {
    val products = listOf(
        Product(1, "Plátano", "Color amarillo", 1, 12, "mano"),
        Product(2, "Banana", "Tulepera con la banana", 1, 20, "hand"),
        Product(3, "Manzana", "Manzana", 1, 10, "unidades")
    )

    ProductListComponent(products = products, decreaseProductQuantity = {}) {}
}

