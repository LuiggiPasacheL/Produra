package com.example.produra.presentation.productForm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.model.Product
import com.example.produra.useCase.products.addOrUpdateProduct.AddOrUpdateProductUseCase
import com.example.produra.useCase.products.getProduct.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val addOrUpdateProductUseCase: AddOrUpdateProductUseCase,
    val getProductUseCase: GetProductUseCase
) : ViewModel() {
    var state by mutableStateOf(AddProductState())
        private set

    private val productId: Int? = savedStateHandle["productId"]

    init {
        viewModelScope.launch {
            if (productId != null) {
                val product = getProductUseCase(productId)
                product?.let { p ->
                    state = state.copy(product = p)
                }
            }
        }
    }

    fun actionForm() {
        viewModelScope.launch {
            val product = state.product
            addOrUpdateProductUseCase(product)
        }
    }

    fun onValueChanged(
        product: Product
    ) {
        this.state = this.state.copy(
            product = product
        )
    }
}