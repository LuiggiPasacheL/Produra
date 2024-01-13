package com.example.produra.presentation.productList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.useCase.products.getProducts.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductListViewModel(
    val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    var state by mutableStateOf(ProductListState())
        private set

    fun loadProducts() {
        viewModelScope.launch {
            val products = getProductsUseCase()
            state = state.copy(products = products)
        }
    }
}