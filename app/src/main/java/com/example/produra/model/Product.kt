package com.example.produra.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "minQuantity") val minQuantity: Number,
    @ColumnInfo(name = "quantity") val quantity: Number,
    @ColumnInfo(name = "units") val units: String
)