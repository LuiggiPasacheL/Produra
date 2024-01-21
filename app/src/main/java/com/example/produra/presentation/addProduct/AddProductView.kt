package com.example.produra.presentation.addProduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddProductView(
    viewModel: AddProductViewModel = hiltViewModel(), onNavigateToListProducts: () -> Unit
) {
    val state = viewModel.state

    Column(Modifier.fillMaxSize()) {
        TextField(value = state.product.name, label = { Text("Nombre") }, onValueChange = { name ->
            val product = state.product.copy(name = name)
            viewModel.onValueChanged(product = product)
        })
        TextField(value = state.product.description,
            label = { Text("Descripción") },
            onValueChange = { description ->
                val product = state.product.copy(description = description)
                viewModel.onValueChanged(product = product)
            })
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                viewModel.actionForm()
                onNavigateToListProducts()
            }) {
                Text(text = "Agregar producto")
            }
            Button(onClick = {
                onNavigateToListProducts()
            }) {
                Text(text = "Retroceder")
            }
        }
    }
}