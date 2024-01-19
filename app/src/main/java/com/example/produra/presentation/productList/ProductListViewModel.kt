package com.example.produra.presentation.productList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.model.Product
import com.example.produra.useCase.products.listProducts.ListProductsUseCase
import com.example.produra.useCase.products.updateProduct.UpdateProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    val listProductsUseCase: ListProductsUseCase,
    val updateProductUseCase: UpdateProductUseCase
) : ViewModel() {
    var state by mutableStateOf(ProductListState())
        private set

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            val products = listProductsUseCase()
            state = state.copy(products = products)
        }
    }

    fun toggleProductChanged() {
        state = state.copy(productChanged = !state.productChanged)
    }

    fun decreaseProductQuantity(product: Product) {
        viewModelScope.launch {
            val newProduct = product.copy(quantity = product.quantity - 1)
            updateProductUseCase(newProduct)
            toggleProductChanged()
        }
    }

    fun increaseProductQuantity(product: Product) {
        viewModelScope.launch {
            val newProduct = product.copy(quantity = product.quantity + 1)
            updateProductUseCase(newProduct)
            toggleProductChanged()
        }
    }
}