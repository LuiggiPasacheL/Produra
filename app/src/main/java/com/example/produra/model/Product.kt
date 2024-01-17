package com.example.produra.model

data class Product(
    val id: Int?,
    val name: String,
    val description: String,
    val minQuantity: Int,
    val quantity: Int,
    val units: String
)