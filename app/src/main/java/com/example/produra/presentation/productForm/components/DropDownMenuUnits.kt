package com.example.produra.presentation.productForm.components

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

@Composable
fun DropdownUnits(label: String, onValueChange: (String) -> Unit, elements: List<String>) {

    var selectedItem by remember {
        mutableStateOf("")
    }

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = if (selectedItem == "") label else selectedItem,
            onValueChange = {},
            enabled = false,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .fillMaxWidth(),
            trailingIcon = { Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null) }
        )
        DropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            elements.forEach { e ->
                DropdownMenuItem(text = { Text(e) }, onClick = {
                    onValueChange(e)
                    selectedItem = e
                    isExpanded = false
                })
            }
            DropdownMenuItem(text = { Text("Ninguno") }, onClick = { isExpanded = false })
        }
    }
}

@Preview
@Composable
fun PreviewDropdownUnits(){
    val elements = listOf(
        "elemento 1",
        "elemento 2"
    )
    DropdownUnits(label = elements.first(), onValueChange = {}, elements = elements)
}