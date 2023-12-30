package com.example.produra.presentation.addProduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.produra.presentation.addProduct.components.DropdownUnits

@Composable
fun AddProductView() {
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
            value = it
        })
        TextField(value = value, label = { Text("Descripción") }, onValueChange = {
            value = it
        })
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = value, label = { Text("Cantidad") }, onValueChange = {
                value = it
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
fun PreviewAddProduct() {
    AddProductView()
}