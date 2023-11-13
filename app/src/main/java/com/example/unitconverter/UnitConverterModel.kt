package com.example.unitconverter

import kotlin.math.roundToInt

data class UnitConverterModel(
    var inputValue: String,
    var outputValue: String,
    var inputUnit: String,
    var outputUnit: String,
    var iExpanded: Boolean,
    var oExpanded: Boolean,
    var inputConversionFactor: Double,
    var outputConversionFactor: Double

)

class UnitConverterRepository {
    private var _model = UnitConverterModel("","","","",
        iExpanded = false,
        oExpanded = false,
        inputConversionFactor = 0.0,
        outputConversionFactor = 0.0
    )

    fun getModel() = _model

    fun onSelectInputUnit(unit: String, conversionFactor: Double) {
        _model.iExpanded = false
        _model.inputUnit = unit
        _model.inputConversionFactor = conversionFactor
        convertUnits()
    }

    fun onSelectOutputUnit(unit: String, conversionFactor: Double) {
        _model.oExpanded = false
        _model.outputUnit = unit
        _model.outputConversionFactor = conversionFactor
        convertUnits()
    }

    fun convertUnits() {
        val inputValueDouble = _model.inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * _model.inputConversionFactor * 100.0 / _model.outputConversionFactor).roundToInt() / 100.0
        _model.outputValue = result.toString()
    }
}