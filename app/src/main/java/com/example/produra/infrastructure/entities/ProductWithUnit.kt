package com.example.produra.infrastructure.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ProductWithUnit (
    @Embedded val productEntity: ProductEntity,
    @Relation(
        parentColumn = "unitId",
        entityColumn = "unitId"
    )
    val unitEntity: UnitEntity
)