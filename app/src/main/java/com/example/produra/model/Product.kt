package com.example.produra.model

import java.math.BigDecimal
import java.util.Date

data class Product (
    val id: Int?,
    val name: String,
    val description: String?,
    val targetAmount: Int,
    val renewalDate: Date,
)