package com.example.unitconverter.domain

import com.example.unitconverter.data.UnitConverterModel

interface UnitConverterRepository {
    val model: UnitConverterModel
    fun onSelectInputUnit(unit: String, conversionFactor: Double)

    fun onSelectOutputUnit(unit: String, conversionFactor: Double)

    fun onInputValueChange(newValue: String)
}