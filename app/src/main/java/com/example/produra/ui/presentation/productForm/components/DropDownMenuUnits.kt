package com.example.produra.ui.presentation.productForm.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.produra.model.PUnit

@Composable
fun DropdownUnits(
    label: String,
    onValueChange: (PUnit) -> Unit,
    elements: List<PUnit>,
    modifier: Modifier
) {

    var selectedItem by remember {
        mutableStateOf(PUnit.createEmpty())
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            label = { Text(text = label) },
            value = /* if (selectedItem.measure == "") label else */ selectedItem.measure,
            onValueChange = {},
            enabled = false,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
        )
        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            elements.forEach { e ->
                DropdownMenuItem(text = { Text(e.measure) }, onClick = {
                    onValueChange(e)
                    selectedItem = e
                    isExpanded = false
                })
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropdownUnits() {
    val elements = listOf(
        PUnit(1, "Kg"),
        PUnit(2, "G"),
        PUnit(3, "unidades")
    )
    DropdownUnits(
        label = elements.first().measure,
        onValueChange = {},
        elements = elements,
        modifier = Modifier
    )
}