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
    @ColumnInfo(name = "mustBePurchased") val mustBePurchased: Boolean,
) {
    companion object {
        fun fromProduct(p: Product): ProductEntity {
            return ProductEntity(
                id = p.id,
                description = p.description,
                mustBePurchased = p.mustBePurchased,
                name = p.name
            )
        }
    }

    fun toProduct(): Product {
        return Product(
            id = this.id,
            mustBePurchased = this.mustBePurchased,
            description = this.description,
            name = this.name
        )
    }
}
