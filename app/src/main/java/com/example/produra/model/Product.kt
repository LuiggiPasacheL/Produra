package com.example.produra.model

data class Product(
    val productId: Int?,
    val name: String,
    val description: String,
    val mustBePurchased: Boolean,
    val amount: Double,
    val thresholdAmount: Double?,
    val unit: PUnit?
) {

    companion object {
        fun createEmpty(): Product {
            return Product(
                productId = null,
                name = "",
                description = "",
                mustBePurchased = false,
                amount = 0.0,
                thresholdAmount = null,
                unit = null
            )
        }
    }
}