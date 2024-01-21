package com.example.produra.presentation.productList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    val alignment = Alignment.CenterVertically
    Row(
        modifier
            .background(Color.White)
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colorScheme.secondary),
        verticalAlignment = alignment,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp)) {
            Text(text = product.name)
        }
        Box {
            Row(Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp), verticalAlignment = alignment) {
                println(product.id.toString() + " " + product.mustBePurchased.toString())
                Button(onClick = { toggleProductMustBePurchased(product) }) {
                    if (product.mustBePurchased) {
                        Text(text = "Necesito comprar este producto")
                    } else {
                        Text(text = "Ya compré este producto")
                    }
                }
            }
        }
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