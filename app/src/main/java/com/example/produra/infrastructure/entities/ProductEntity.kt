package com.example.produra.infrastructure.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.produra.model.Product

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "minQuantity") val minQuantity: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,
    @ColumnInfo(name = "units") val units: String
) {
    companion object {
        fun fromProduct(p: Product): ProductEntity {
            return ProductEntity(
                id = p.id,
                units = p.units,
                quantity = p.quantity,
                minQuantity = p.minQuantity,
                description = p.description,
                name = p.name
            )
        }
    }

    fun toProduct(): Product {
        return Product(
            id = this.id,
            units = this.units,
            quantity = this.quantity,
            minQuantity = this.minQuantity,
            description = this.description,
            name = this.name
        )
    }
}
