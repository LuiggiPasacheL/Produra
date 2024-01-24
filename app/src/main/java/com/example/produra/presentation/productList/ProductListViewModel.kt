package com.example.produra.presentation.productList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.model.Product
import com.example.produra.useCase.products.addOrUpdateProduct.AddOrUpdateProductUseCase
import com.example.produra.useCase.products.listProducts.ListProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    val listProductsUseCase: ListProductsUseCase,
    val updateProductUseCase: AddOrUpdateProductUseCase
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

    fun toggleProductMustBePurchased(p: Product) {
        viewModelScope.launch {
            val product = p.copy(mustBePurchased = !p.mustBePurchased)
            updateProductUseCase(product)
        }
    }
}