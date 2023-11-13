package com.example.unitconverter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class UnitConverterViewModel(private val repository: UnitConverterRepository): ViewModel() {

    private val _inputValue = mutableStateOf(repository.getModel().inputValue)
    val inputValue = _inputValue
    private val _outputValue = mutableStateOf(repository.getModel().outputValue)
    val outputValue = _outputValue
    private val _inputUnit = mutableStateOf(repository.getModel().inputUnit)
    val inputUnit = _inputUnit
    private val _outputUnit = mutableStateOf(repository.getModel().outputUnit)
    val outputUnit = _outputUnit
    private val _iExpanded = mutableStateOf(repository.getModel().iExpanded)
    val iExpanded = _iExpanded
    private val _oExpanded = mutableStateOf(repository.getModel().oExpanded)
    val oExpanded = _oExpanded

    fun onSelectInputUnit(unit: String, conversionFactor: Double) {
        repository.onSelectInputUnit(unit, conversionFactor)
    }

    fun onSelectOutputUnit(unit: String, conversionFactor: Double) {
        repository.onSelectOutputUnit(unit, conversionFactor)
    }

    fun convertUnits() {
        repository.convertUnits()
    }
}