package com.example.produra.model

data class PUnit (
    val unitId: Int?,
    val measure: String
) {
    companion object {
        fun createEmpty(): PUnit {
            return PUnit(
                unitId = 0,
                measure = ""
            )
        }
    }
}
