package com.example.produra.ui.presentation.productList.components

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
import com.example.produra.model.PUnit
import com.example.produra.model.Product

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    toggleProductMustBePurchased: (Product) -> Unit,
    onNavigateToProduct: (id: Int) -> Unit
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
        ) {
            Box {
                Row(Modifier.padding(10.dp, 15.dp, 0.dp, 15.dp), verticalAlignment = alignment) {
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
            Box(
                Modifier
                    .clickable { showDetails = !showDetails }
                    .fillMaxWidth()
                    .padding(15.dp, 15.dp, 100.dp, 15.dp)
            ) {
                Text(text = product.name)
            }
        }
        if (showDetails) {
            ProductDetails(product = product, onNavigateToProduct = onNavigateToProduct)
        }
    }
}

@Composable
fun ProductDetails(product: Product, onNavigateToProduct: (id: Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = product.description, color = Color.White)
        Button(onClick = { onNavigateToProduct(product.productId!!) }) {
            Text(text = "Ver más")
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {

    val u = PUnit.createEmpty()

    val p = Product.createEmpty(u).copy(
        productId = 1, name = "Plátano", description = "Color amarillo", mustBePurchased = true,
    )

    ProductCard(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp),
        product = p,
        toggleProductMustBePurchased = { },
        onNavigateToProduct = { }
    )
}