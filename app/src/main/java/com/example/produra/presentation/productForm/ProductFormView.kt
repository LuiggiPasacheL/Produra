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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.model.PUnit
import com.example.produra.presentation.productForm.components.DropdownUnits

@Composable
fun ProductFormView(
    viewModel: ProductFormViewModel = hiltViewModel(), onNavigateToListProducts: () -> Unit
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Añadir Producto",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp
            )
            Column(modifier = Modifier.padding(7.dp)) {
                TextField(
                    modifier = Modifier.padding(7.dp),
                    value = state.product.name,
                    label = { Text("Nombre") },
                    onValueChange = { name ->
                        val product = state.product.copy(name = name)
                        viewModel.onValueChanged(product = product)
                    })
                TextField(
                    modifier = Modifier.padding(7.dp),
                    value = state.product.description,
                    label = { Text("Descripción") },
                    onValueChange = { description ->
                        val product = state.product.copy(description = description)
                        viewModel.onValueChanged(product = product)
                    })
                // TODO: Add comboBox to select Unit and attach to a product
                Row {
                    TextField(
                        modifier = Modifier.padding(7.dp),
                        value = state.product.amount.toString(),
                        label = { Text("Cantidad Actual") },
                        onValueChange = { quantity ->
                            val amount: Double? = quantity.toDoubleOrNull()
                            if (amount != null) {
                                val product = state.product.copy(amount = amount)
                                viewModel.onValueChanged(product = product)
                            }
                        })
                    DropdownUnits(
                        label = "Medida",
                        onValueChange = {unit ->
                            val product = state.product.copy(unit = unit)
                            viewModel.onValueChanged(product = product)
                        },
                        elements = state.units)
                }
                // Before of this
                Row(
                    modifier = Modifier
                        .height(48.dp)
                        .clickable {
                            val mustBePurchased = state.product.mustBePurchased
                            val product = state.product.copy(mustBePurchased = !mustBePurchased)
                            viewModel.onValueChanged(product = product)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = state.product.mustBePurchased,
                        onCheckedChange = { mustBePurchased ->
                            val product = state.product.copy(mustBePurchased = !mustBePurchased)
                            viewModel.onValueChanged(product = product)
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