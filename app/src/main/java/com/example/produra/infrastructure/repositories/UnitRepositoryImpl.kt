package com.example.produra.infrastructure.repositories

import com.example.produra.infrastructure.dao.UnitDao
import com.example.produra.infrastructure.entities.ProductEntity
import com.example.produra.infrastructure.entities.UnitEntity
import com.example.produra.model.PUnit
import com.example.produra.useCase.units.UnitRepository
import javax.inject.Inject

class UnitRepositoryImpl @Inject constructor(
    private val unitDao: UnitDao
): UnitRepository{
    override suspend fun save(u: PUnit) {
        if (u.unitId == null) {
            val unitEntity = UnitEntity.fromPUnit(u)
            unitDao.addUnit(unitEntity)
            return
        }
        val unitEntity = UnitEntity.fromPUnit(u)
        unitDao.updateEntity(unitEntity)
    }

    override suspend fun getById(id: Int): PUnit? {
        return unitDao.getUnitById(id)?.toUnit()
    }

    override suspend fun getAll(): List<PUnit> {
        return unitDao.getUnits().map { unitEntity -> unitEntity.toUnit() }
    }
}