package com.example.produra.presentation.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.productList.components.ProductListComponent

@Composable
fun CartView(
    viewModel: CartViewModel = hiltViewModel(),
    onNavigateToListProducts: () -> Unit,
    onNavigateToProduct: (id: Int) -> Unit
) {
    val state = viewModel.state

    LaunchedEffect(key1 = state) {
        viewModel.onLoadAction()
        viewModel.reloadPage()
    }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onNavigateToListProducts,
            ) {
                Text(text = "Volver")
            }
            Text(
                text = "Carrito de compras",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(25.dp),
                textAlign = TextAlign.Center
            )
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
}