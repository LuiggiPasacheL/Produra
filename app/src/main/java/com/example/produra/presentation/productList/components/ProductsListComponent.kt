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
    toggleProductMustBePurchased: (Product) -> Unit,
) {
    LazyColumn {
        items(products) { product ->
            ProductCard(
                product = product, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
                toggleProductMustBePurchased = toggleProductMustBePurchased,
            )
        }
    }
}

@Preview
@Composable
fun ProductListComponentPreview() {
    val products = listOf(
        Product(1, "Plátano", "Color amarillo", true),
        Product(2, "Banana", "Tulepera con la banana", false),
        Product(3, "Manzana", "Manzana", true)
    )

    ProductListComponent(products = products, toggleProductMustBePurchased = {})
}

