package com.example.produra.presentation.productList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.productList.components.ProductListComponent

@Composable
fun ProductListView(
    viewModel: ProductListViewModel = hiltViewModel(),
    onNavigateToAddProduct: () -> Unit
) {
    val state = viewModel.state

    LaunchedEffect(key1 = state) {
        viewModel.loadProducts()
        viewModel.toggleProductChanged()
    }

    Column {
        Text(text = "Hello World", style = MaterialTheme.typography.titleMedium)
        ProductListComponent(
            products = state.products,
            decreaseProductQuantity = { viewModel.decreaseProductQuantity(it) },
            increaseProductQuantity = { viewModel.increaseProductQuantity(it) }
        )
    }

    Button(
        onClick = onNavigateToAddProduct,
        modifier = Modifier
            .absoluteOffset(x = 300.dp, y = 650.dp)
            .height(60.dp)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add product")
    }
}