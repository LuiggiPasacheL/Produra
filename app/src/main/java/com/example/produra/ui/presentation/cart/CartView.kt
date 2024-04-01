package com.example.produra.ui.presentation.cart

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.produra.R
import com.example.produra.model.PUnit
import com.example.produra.model.Product
import com.example.produra.ui.presentation.productList.components.ProductListComponent

@Composable
fun CartView(
    viewModel: CartViewModel = hiltViewModel(),
    onNavigateToListProducts: () -> Unit,
    onNavigateToProduct: (id: Int) -> Unit
) {
    val state = viewModel.state

    LaunchedEffect(key1 = state) {
        viewModel.onLoadAction()
        viewModel.reloadPage()
    }

    Cart(
        state,
        viewModel::toggleProductMustBePurchased,
        onNavigateToListProducts,
        onNavigateToProduct
    )
}

@Composable
fun Cart(
    state: CartState,
    toggleProductMustBePurchased: (product: Product) -> Unit,
    onNavigateToListProducts: () -> Unit,
    onNavigateToProduct: (id: Int) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onNavigateToListProducts,
            ) {
                Text(text = stringResource(id = R.string.back))
            }
            Text(
                text = stringResource(id = R.string.cart_title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(25.dp),
                textAlign = TextAlign.Center
            )
        }
        ProductListComponent(
            products = state.products, toggleProductMustBePurchased = { product ->
                toggleProductMustBePurchased(
                    product
                )
            }, onNavigateToProduct = onNavigateToProduct
        )
    }
}

@Composable
@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Preview(name = "Full Preview", showSystemUi = true, showBackground = true)
fun CartPreview() {

    val productEmpty = Product.createEmpty(PUnit.createEmpty())

    val products = listOf(
        productEmpty.copy(name = "Product 1"),
        productEmpty.copy(name = "Product 2"),
        productEmpty.copy(name = "Product etc"),
    )

    val state = CartState(products = products)
    val toggleProductMustBePurchased: (product: Product) -> Unit = {}
    val onNavigateToListProducts: () -> Unit = {}
    val onNavigateToProduct: (id: Int) -> Unit = {}

    Cart(
        state,
        toggleProductMustBePurchased,
        onNavigateToListProducts,
        onNavigateToProduct
    )
}