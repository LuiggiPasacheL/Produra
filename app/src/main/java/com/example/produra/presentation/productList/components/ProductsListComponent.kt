package com.example.produra.presentation.productList.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.produra.model.PUnit
import com.example.produra.model.Product

@Composable
fun ProductListComponent(
    products: List<Product>,
    toggleProductMustBePurchased: (Product) -> Unit,
    onNavigateToProduct: (id: Int) -> Unit,
) {
    LazyColumn {
        items(products) { product ->
            ProductCard(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp), product = product,
                toggleProductMustBePurchased = toggleProductMustBePurchased,
                onNavigateToProduct = onNavigateToProduct
            )
        }
    }
}

@Preview
@Composable
fun ProductListComponentPreview() {
    val u = PUnit.createEmpty()
    val products = listOf(
        Product.createEmpty(u).copy(
            productId = 1,
            name = "Plátano",
            description = "Color amarillo",
            mustBePurchased = true
        ),
        Product.createEmpty(u).copy(
            productId = 2,
            name = "Banana",
            description = "Tulepera con la banana",
            mustBePurchased = false,
            amount = 0.0,
            thresholdAmount = null,
        ),
        Product.createEmpty(u).copy(
            productId = 3,
            name = "Manzana",
            description = "Manzana",
            mustBePurchased = true, amount = 0.0, thresholdAmount = null,
        ),
    )

    ProductListComponent(
        products = products,
        toggleProductMustBePurchased = {},
        onNavigateToProduct = {})
}

