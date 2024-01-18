package com.example.produra.presentation.addProduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.addProduct.components.DropdownUnits

@Composable
fun AddProductView(viewModel: AddProductViewModel = hiltViewModel(), onNavigateToListProducts: () -> Unit) {
    val state = viewModel.state

    Column(Modifier.fillMaxSize()) {
        val quantityOptions = listOf(
            "kg", "g", "unidad", "mano"
        )
        TextField(value = state.name, label = { Text("Nombre") }, onValueChange = { name ->
            viewModel.onValueChanged(name = name)
        })
        TextField(value = state.description,
            label = { Text("Descripción") },
            onValueChange = { description ->
                viewModel.onValueChanged(description = description)
            })
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = state.quantity.toString(),
                label = { Text("Cantidad") },
                onValueChange = { quantity ->
                    if (quantity != "") {
                        viewModel.onValueChanged(quantity = quantity.toInt())
                    }
                })
            DropdownUnits(
                label = "medida", onValueChange = { units ->
                    viewModel.onValueChanged(units = units)
                }, elements = quantityOptions
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = state.minQuantity.toString(),
                label = { Text("Cantidad minima") },
                onValueChange = { minQuantity ->
                    if (minQuantity != "") {
                        viewModel.onValueChanged(minQuantity = minQuantity.toInt())
                    }
                })
            DropdownUnits(
                label = "medida", onValueChange = { units ->
                    viewModel.onValueChanged(units = units)
                }, elements = quantityOptions
            )
        }
        Button(onClick = {
            viewModel.actionForm()
            onNavigateToListProducts()
        }) {
            Text(text = "Agregar producto")
        }
    }
}