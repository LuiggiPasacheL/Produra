package com.example.produra.ui.presentation.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.model.Product
import com.example.produra.useCase.products.addOrUpdateProduct.AddOrUpdateProductUseCase
import com.example.produra.useCase.products.listProducts.CartProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    val cartProductsUseCase: CartProductsUseCase,
    val updateProductUseCase: AddOrUpdateProductUseCase
): ViewModel() {
    var state by mutableStateOf(CartState())
        private set

    init {
        onLoadAction()
    }

    fun onLoadAction() {
        viewModelScope.launch {
            val products = cartProductsUseCase()
            state = state.copy(products = products)
        }
    }

    fun reloadPage() {
        state = state.copy(takeOutCart = !state.takeOutCart)
    }

    fun toggleProductMustBePurchased(p: Product) {
        viewModelScope.launch {
            val product = p.copy(mustBePurchased = !p.mustBePurchased)
            updateProductUseCase(product)
        }
    }
}