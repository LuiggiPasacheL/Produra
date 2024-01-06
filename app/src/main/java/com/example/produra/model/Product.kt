package com.example.produra.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (
    @PrimaryKey val id: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="description") val description: String?,
    @ColumnInfo(name="minQuantity") val minQuantity: Number,
    @ColumnInfo(name="maxQuantity") val maxQuantity: Number?,
    @ColumnInfo(name="unit") val unit: String
)