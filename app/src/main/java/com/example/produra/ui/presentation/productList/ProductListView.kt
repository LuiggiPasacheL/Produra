package com.example.produra.ui.presentation.productList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.ui.presentation.productList.components.ProductListComponent

@Composable
fun ProductListView(
    viewModel: ProductListViewModel = hiltViewModel(),
    onNavigateToAddProduct: () -> Unit,
    onNavigateToCart: () -> Unit,
    onNavigateToProduct: (id: Int) -> Unit
) {
    val state = viewModel.state

    LaunchedEffect(key1 = state) {
        viewModel.loadProducts()
        viewModel.toggleProductChanged()
    }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Productos",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(25.dp),
                textAlign = TextAlign.Center
            )
            Button(
                onClick = onNavigateToCart
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Navigate to cart"
                )
            }
        }
        ProductListComponent(
            products = state.products,
            toggleProductMustBePurchased = { product ->
                viewModel.toggleProductMustBePurchased(
                    product
                )
            },
            onNavigateToProduct = onNavigateToProduct
        )
    }

    Button(
        onClick = onNavigateToAddProduct,
        modifier = Modifier
            .absoluteOffset(x = 300.dp, y = 650.dp)
            .height(60.dp)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Navigate to add product")
    }
}