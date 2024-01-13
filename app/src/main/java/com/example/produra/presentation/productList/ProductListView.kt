package com.example.produra.presentation.productList

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.produra.model.Product


@Composable
fun ProductListView(products: List<Product>) {
    // TODO: aquí viene una lista de productos, por ejemplo
    // NOTE: Esto será parecido a la parte de hábitos en TickTick
    // Producto 1   |   - {Cantidad actual} + | flecha pa abajo
        // Detalles
        // Ver más
}

@Preview
@Composable
fun ProductListPreview() {
    val products: List<Product> = listOf()

}