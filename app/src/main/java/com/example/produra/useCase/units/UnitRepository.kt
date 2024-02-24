package com.example.produra.useCase.units

import com.example.produra.model.PUnit

interface UnitRepository {
    suspend fun save(u: PUnit)
    suspend fun getById(id: Int): PUnit?
    suspend fun getAll(): List<PUnit>
}