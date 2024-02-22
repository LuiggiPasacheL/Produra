package com.example.produra.model

data class Product(
    val productId: Int?,
    val name: String,
    val description: String,
    val mustBePurchased: Boolean,
    val amount: Double,
    val thresholdAmount: Double?,
    val unitId: Int
) {
}