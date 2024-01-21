package com.example.produra.presentation.productList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.produra.model.Product

@Composable
fun ProductCard(
    modifier: Modifier = Modifier, product: Product, toggleProductMustBePurchased: (Product) -> Unit
) {
    var showDetails by remember { mutableStateOf(false) }

    val alignment = Alignment.CenterVertically
    Column(
        modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colorScheme.secondary),
            verticalAlignment = alignment,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .clickable { showDetails = !showDetails }
                    .fillMaxWidth(0.75f)
                    .padding(10.dp, 15.dp, 100.dp, 15.dp)
            ) {
                Text(text = product.name)
            }
            Box {
                Row(Modifier.padding(10.dp, 15.dp, 10.dp, 15.dp), verticalAlignment = alignment) {
                    Button(onClick = { toggleProductMustBePurchased(product) }) {
                        if (product.mustBePurchased) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Necesito comprar este producto"
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Necesito comprar este producto"
                            )
                        }
                    }
                }
            }
        }
        if (showDetails) {
            ProductDetails(product = product)
        }
    }
}

@Composable
fun ProductDetails(product: Product) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(20.dp)
    ) {
        Text(text = product.description, color = Color.White)
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    val p = Product(
        1, "Plátano", "Color amarillo", true
    )

    ProductCard(product = p,
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
        toggleProductMustBePurchased = { })
}