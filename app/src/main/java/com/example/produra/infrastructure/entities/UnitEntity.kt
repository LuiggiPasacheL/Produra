package com.example.produra.infrastructure.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.produra.model.PUnit

@Entity(tableName = "units")
data class UnitEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="unitId")val unitId: Int,
    @ColumnInfo(name="measure") val measure: String,
) {

    companion object {
        fun fromPUnit(u: PUnit) : UnitEntity {
            return UnitEntity(
                unitId = u.unitId,
                measure = u.measure,
            )
        }
    }
    fun toUnit() : PUnit {
        return PUnit(
            unitId = this.unitId,
            measure = this.measure,
        )
    }
}