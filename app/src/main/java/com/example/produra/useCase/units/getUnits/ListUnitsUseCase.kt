package com.example.produra.useCase.units.getUnits

import com.example.produra.model.PUnit
import com.example.produra.useCase.units.UnitRepository
import javax.inject.Inject

class ListUnitsUseCase @Inject constructor(
    private val unitRepository: UnitRepository
) {
    suspend operator fun invoke(): List<PUnit> {
        // TODO: Add predefined units and delete this listOf
        return unitRepository.getAll() + listOf(
            PUnit(unitId = null, measure = "Kg"),
            PUnit(unitId = null, measure = "g"),
            PUnit(unitId = null, measure = "unidades")
        )
    }
}