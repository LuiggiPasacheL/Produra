package com.example.produra.presentation.productList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.productList.components.ProductListComponent


@Composable
fun ProductListView(productListViewModel: ProductListViewModel = hiltViewModel()) {
    val state = productListViewModel.state
    // TODO: aquí viene una lista de productos, por ejemplo
    // NOTE: Esto será parecido a la parte de hábitos en TickTick
    // Producto 1   |   - {Cantidad actual} + | flecha pa abajo
        // Detalles
        // Ver más
    Column {
        Text(text = "Hello World", style = MaterialTheme.typography.titleMedium)
        ProductListComponent(products = state.products)
    }
}