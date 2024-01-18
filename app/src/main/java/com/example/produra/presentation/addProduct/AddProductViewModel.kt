package com.example.produra.presentation.addProduct

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.useCase.products.addProduct.AddProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
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

    fun onValueChanged(
        name: String? = null,
        description: String? = null,
        minQuantity: Int? = null,
        quantity: Int? = null,
        units: String? = null
    ) {
        this.state = this.state.copy(
            name = name ?: state.name,
            description = description ?: state.description,
            minQuantity = minQuantity ?: state.minQuantity,
            quantity = quantity ?: state.quantity,
            units = units ?: state.units
        )
    }
}