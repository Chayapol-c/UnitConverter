package com.example.unitconverter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class UnitConverterViewModel: ViewModel() {
    private val _inputValue: MutableState<String> = mutableStateOf("")
    var inputValue = _inputValue
    private val _outputValue:MutableState<String> = mutableStateOf("")
    var outputValue = _outputValue
    private val _inputUnit: MutableState<String> = mutableStateOf("Meters")
    var inputUnit = _inputUnit
    private val _outputUnit: MutableState<String> = mutableStateOf("Meters")
    var outputUnit = _outputUnit
    private val _iExpanded: MutableState<Boolean> = mutableStateOf(false)
    var iExpanded = _iExpanded
    private val _oExpanded: MutableState<Boolean> = mutableStateOf(false)
    var oExpanded = _oExpanded
    private val _inputConversionFactor: MutableState<Double> = mutableDoubleStateOf(1.00)
    private val _outputConversionFactor: MutableState<Double> = mutableDoubleStateOf(1.00)

    fun onSelectInputUnit(unit: String, conversionFactor: Double) {
        _iExpanded.value = false
        _inputUnit.value = unit
        _inputConversionFactor.value = conversionFactor
        convertUnits()
    }

    fun onSelectOutputUnit(unit: String, conversionFactor: Double) {
        _oExpanded.value = false
        _outputUnit.value = unit
        _outputConversionFactor.value = conversionFactor
        convertUnits()
    }

    fun convertUnits() {
        val inputValueDouble = _inputValue.value.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * _outputConversionFactor.value!! * 100.0 / _outputConversionFactor.value).roundToInt() / 100.0
        outputValue.value = result.toString()
    }
}