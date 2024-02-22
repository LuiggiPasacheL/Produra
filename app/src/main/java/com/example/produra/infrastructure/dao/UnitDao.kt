package com.example.produra.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.produra.infrastructure.entities.UnitEntity
import com.example.produra.infrastructure.entities.UnitWithProducts

@Dao
interface UnitDao {
    @Insert
    suspend fun addUnit(u: UnitEntity)

    @Query("SELECT * FROM units")
    suspend fun getUnits(): List<UnitEntity>

    @Query("SELECT * FROM units WHERE unitId = :id")
    suspend fun getUnitById(id: Int): UnitEntity?

    @Transaction
    @Query("SELECT * FROM units")
    suspend fun getUnitsWithProducts(): List<UnitWithProducts>
}