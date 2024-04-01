package com.example.produra.ui.presentation.productForm

import android.content.res.Configuration
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.R
import com.example.produra.model.PUnit
import com.example.produra.ui.presentation.productForm.components.DropdownUnits

@Composable
fun ProductFormView(
    viewModel: ProductFormViewModel = hiltViewModel(), onNavigateToListProducts: () -> Unit
) {
    val state = viewModel.state

    ProductForm(
        state = state,
        onValueChanged = viewModel::onValueChanged,
        actionForm = viewModel::actionForm,
        onNavigateToListProducts = onNavigateToListProducts
    )

}

@Composable
fun ProductForm(
    state: ProductFormState, onValueChanged: (
        name: String?, description: String?, quantity: String?, selectedUnit: PUnit?, mustBePurchased: Boolean?
    ) -> Unit, actionForm: () -> Unit, onNavigateToListProducts: () -> Unit
) {
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
                text = stringResource(id = R.string.add_product),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 30.sp
            )
            Column(modifier = Modifier.padding(7.dp)) {
                TextField(modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                    value = state.name,
                    label = { Text(stringResource(id = R.string.name)) },
                    onValueChange = { name ->
                        onValueChanged(name, null, null, null, null)
                    })
                TextField(modifier = Modifier
                    .padding(7.dp)
                    .fillMaxWidth(),
                    value = state.description,
                    label = { Text(stringResource(id = R.string.description)) },
                    onValueChange = { description ->
                        onValueChanged(null, description, null, null, null)
                    })
                Row {
                    TextField(
                        modifier = Modifier
                            .padding(7.dp)
                            .width(200.dp),
                        value = state.quantity,
                        label = { Text(stringResource(id = R.string.name)) },
                        onValueChange = { quantity ->
                            onValueChanged(null, null, quantity, null, null)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    DropdownUnits(
                        label = stringResource(id = R.string.unit),
                        modifier = Modifier.padding(7.dp),
                        onValueChange = { unit ->
                            onValueChanged(null, null, null, unit, null)
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
                            onValueChanged(null, null, null, null, !mustBePurchased)
                        }, verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = state.mustBePurchased,
                        onCheckedChange = { mustBePurchased ->
                            onValueChanged(null, null, null, null, mustBePurchased)
                        },
                        enabled = true,
                    )
                    Spacer(Modifier.width(32.dp))
                    Text(stringResource(id = R.string.must_pursh))
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
                actionForm()
                onNavigateToListProducts()
            }) {
                Text(text = stringResource(id = R.string.next))
            }
            Button(onClick = {
                onNavigateToListProducts()
            }) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }

}

@Composable
@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true, showBackground = true)
fun ProductFormPreview() {
    val state = ProductFormState()

    val onValueChanged: (
        name: String?, description: String?, quantity: String?, selectedUnit: PUnit?, mustBePurchased: Boolean?
    ) -> Unit = { _, _, _, _, _ -> }
    val actionForm: () -> Unit = {}
    val onNavigateToListProducts: () -> Unit = {}

    ProductForm(state, onValueChanged, actionForm, onNavigateToListProducts)
}