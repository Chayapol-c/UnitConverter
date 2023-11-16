package com.example.unitconverter.data

import com.example.unitconverter.domain.UnitConverterRepository
import kotlin.math.roundToInt

class UnitConverterRepositoryImpl() : UnitConverterRepository {

    override val model: UnitConverterModel = UnitConverterModel()

    override fun onSelectInputUnit(unit: String, conversionFactor: Double) {
        model.iExpanded = false
        model.inputUnit = unit
        model.inputConversionFactor = conversionFactor
        convertUnits()
    }

    override fun onSelectOutputUnit(unit: String, conversionFactor: Double) {
        model.oExpanded = false
        model.outputUnit = unit
        model.outputConversionFactor = conversionFactor
        convertUnits()
    }

    override fun onInputValueChange(newValue: String) {
        model.inputValue = newValue
        convertUnits()
    }

    private fun convertUnits() {
        val inputValueDouble = model.inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * model.inputConversionFactor * 100.0 / model.outputConversionFactor).roundToInt() / 100.0
        model.outputValue = result.toString()
    }

}