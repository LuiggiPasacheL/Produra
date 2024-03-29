package com.example.produra.infrastructure.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.produra.model.Product

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "productId") val productId: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "mustBePurchased") val mustBePurchased: Boolean,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "thresholdAmount") val thresholdAmount: Double?,
    @ColumnInfo(name = "unitId") val unitId: Int
) {
    companion object {
        fun fromProduct(p: Product, unitId: Int): ProductEntity {
            return ProductEntity(
                productId = p.productId,
                description = p.description,
                mustBePurchased = p.mustBePurchased,
                name = p.name,
                amount = p.amount,
                thresholdAmount = p.thresholdAmount,
                unitId = unitId
            )
        }
    }
}
