package com.example.produra.infrastructure.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UnitWithProducts(
    @Embedded val unitEntity: UnitEntity,
    @Relation(
        parentColumn = "unitId",
        entityColumn = "unitId"
    )
    val productEntity: List<ProductEntity>,
)
