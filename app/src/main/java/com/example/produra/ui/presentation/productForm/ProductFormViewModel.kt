package com.example.produra.ui.presentation.productForm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.produra.model.PUnit
import com.example.produra.model.Product
import com.example.produra.useCase.products.addOrUpdateProduct.AddOrUpdateProductUseCase
import com.example.produra.useCase.products.getProduct.GetProductUseCase
import com.example.produra.useCase.units.getUnits.ListUnitsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductFormViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val addOrUpdateProductUseCase: AddOrUpdateProductUseCase,
    val getProductUseCase: GetProductUseCase,
    val listUnitsUseCase: ListUnitsUseCase
) : ViewModel() {
    var state by mutableStateOf(ProductFormState())
        private set

    private val productId: Int? = savedStateHandle["productId"]

    init {
        viewModelScope.launch {
            if (productId != null) {
                val product = getProductUseCase(productId)
                product?.let { p ->
                    state = state.copy(
                        name = product.name,
                        description = product.description,
                        quantity = product.amount.toString(),
                        mustBePurchased = product.mustBePurchased,
                        selectedUnit = product.unit,
                    )
                }
            }

            val units = listUnitsUseCase()
            state = state.copy(units = units)
        }
    }

    fun actionForm() {
        viewModelScope.launch {
            if (state.name == "" || state.description == "" ||
                state.quantity.toDoubleOrNull() == null || state.selectedUnit == null
            ) {
                // TODO: Launch toast and communicate error
                println("ERROR AL AÑADIR PRODUCTO")
                return@launch
            }

            val product = Product(
                productId = null,
                name = state.name,
                description = state.description,
                amount = state.quantity.toDouble(),
                mustBePurchased = state.mustBePurchased,
                unit = state.selectedUnit!!,
                thresholdAmount = null
            )

            addOrUpdateProductUseCase(product)
        }
    }

    fun onValueChanged(
        name: String? = null,
        description: String? = null,
        quantity: String? = null,
        selectedUnit: PUnit? = null,
        mustBePurchased: Boolean? = null
    ) {
        this.state = this.state.copy(
            name = name ?: this.state.name,
            description = description ?: this.state.description,
            quantity = quantity ?: this.state.quantity,
            selectedUnit = selectedUnit ?: this.state.selectedUnit,
            mustBePurchased = mustBePurchased ?: this.state.mustBePurchased
        )
    }
}