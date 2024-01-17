package com.example.produra.presentation.addProduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.addProduct.components.DropdownUnits

@Composable
fun AddProductView(viewModel: AddProductViewModel = hiltViewModel()) {
    var state = viewModel.state

    Column(Modifier.fillMaxSize()) {
        var value by remember {
            mutableStateOf("")
        }
        val timeOptions = listOf(
            "día",
            "semana",
            "mes",
            "año"
        )
        val quantityOptions = listOf(
            "kg",
            "g",
            "unidad",
            "mano"
        )
        TextField(value = value, label = { Text("Nombre") }, onValueChange = {
            state = state.copy(name = it)
        })
        TextField(value = value, label = { Text("Descripción") }, onValueChange = {
            state = state.copy(description = it)
        })
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = value, label = { Text("Cantidad") }, onValueChange = {
                state = state.copy(quantity = it.toInt())
            })
            DropdownUnits(
                label = "medida",
                onValueChange = { },
                elements = quantityOptions
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = value, label = { Text("Tiempo de renovación") }, onValueChange = {
                value = it
            })
            DropdownUnits(
                label = "tiempo",
                onValueChange = { },
                elements = timeOptions
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Agregar producto")
        }
    }
}

@Composable
@Preview
fun AddProductPreview() {
    AddProductView()
}