package com.example.produra.presentation.addProduct

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.useCase.products.addProduct.AddProductUseCase
import kotlinx.coroutines.launch

class AddProductViewModel(
    val addProductUseCase: AddProductUseCase
) : ViewModel() {
    var state by mutableStateOf(AddProductState())
        private set

    fun actionForm() {
        viewModelScope.launch {
            val product = state.toProduct()
            addProductUseCase(product)
        }
    }
}