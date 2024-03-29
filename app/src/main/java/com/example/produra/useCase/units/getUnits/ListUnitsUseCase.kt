package com.example.produra.useCase.units.getUnits

import com.example.produra.model.PUnit
import com.example.produra.useCase.units.UnitRepository
import javax.inject.Inject

class ListUnitsUseCase @Inject constructor(
    private val unitRepository: UnitRepository
) {
    suspend operator fun invoke(): List<PUnit> {
        // TODO: Add predefined units and delete this listOf
        return unitRepository.getAll()
        // + listOf(
        //     PUnit(unitId = 1, measure = "Kg"),
        //     PUnit(unitId = 2, measure = "g"),
        //     PUnit(unitId = 3, measure = "unidades")
        // )
    }
}