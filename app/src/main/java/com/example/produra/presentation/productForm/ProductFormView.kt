package com.example.produra.presentation.productForm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.presentation.productForm.components.DropdownUnits

@Composable
fun ProductFormView(
    viewModel: ProductFormViewModel = hiltViewModel(), onNavigateToListProducts: () -> Unit
) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Añadir Producto",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp
            )
            Column(modifier = Modifier.padding(7.dp)) {
                TextField(modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                    value = state.name,
                    label = { Text("Nombre") },
                    onValueChange = { name ->
                        viewModel.onValueChanged(name = name)
                    })
                TextField(modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                    value = state.description,
                    label = { Text("Descripción") },
                    onValueChange = { description ->
                        viewModel.onValueChanged(description = description)
                    })
                Row {
                    TextField(
                        modifier = Modifier
                            .padding(7.dp)
                            .width(200.dp),
                        value = state.quantity,
                        label = { Text("Cantidad Actual") },
                        onValueChange = { quantity ->
                            viewModel.onValueChanged(quantity = quantity)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    DropdownUnits(
                        label = "Unidad",
                        modifier = Modifier.padding(7.dp),
                        onValueChange = { unit ->
                            viewModel.onValueChanged(selectedUnit = unit)
                        },
                        elements = state.units
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(7.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                        .clickable {
                            val mustBePurchased = state.mustBePurchased
                            viewModel.onValueChanged(mustBePurchased = !mustBePurchased)
                        }, verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = state.mustBePurchased,
                        onCheckedChange = { mustBePurchased ->
                            viewModel.onValueChanged(mustBePurchased = mustBePurchased)
                        },
                        enabled = true,
                    )
                    Spacer(Modifier.width(32.dp))
                    Text("¿Debe ser comprado?")
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
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