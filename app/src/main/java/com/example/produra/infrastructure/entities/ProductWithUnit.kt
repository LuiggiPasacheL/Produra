package com.example.produra.infrastructure.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.example.produra.model.Product

data class ProductWithUnit (
    @Embedded val productEntity: ProductEntity,
    @Relation(
        parentColumn = "unitId",
        entityColumn = "unitId"
    )
    val unitEntity: UnitEntity
) {
    fun toProduct(): Product {
        return Product(
            productId = productEntity.productId,
            name = productEntity.name,
            description = productEntity.description,
            amount = productEntity.amount,
            thresholdAmount = productEntity.thresholdAmount,
            mustBePurchased = productEntity.mustBePurchased,
            unit = unitEntity.toUnit()
        )
    }
}