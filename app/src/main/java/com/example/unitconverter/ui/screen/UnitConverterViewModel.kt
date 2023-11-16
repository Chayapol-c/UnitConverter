package com.example.unitconverter.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unitconverter.UnitConverterApp
import com.example.unitconverter.data.UnitName
import com.example.unitconverter.domain.UnitConverterRepository

class UnitConverterViewModel(private val unitConverterRepository: UnitConverterRepository): ViewModel() {

    private val _inputValue = mutableStateOf("")
    val inputValue = _inputValue
    private val _outputValue = mutableStateOf("")
    val outputValue = _outputValue
    private val _inputUnit = mutableStateOf("")
    val inputUnit = _inputUnit
    private val _outputUnit = mutableStateOf("")
    val outputUnit = _outputUnit
    private val _iExpanded = mutableStateOf(false)
    val iExpanded = _iExpanded
    private val _oExpanded = mutableStateOf(false)
    val oExpanded = _oExpanded
    private val _isInputError = mutableStateOf(false)
    val isInputError = _isInputError
    private val _errorMessage = mutableStateOf("")
    val errorMessage = _errorMessage


    fun onSelectInputUnit(unit: String, conversionFactor: Double) {
        val isInputValid = validateUnit(unit)
        if (isInputValid) {
            unitConverterRepository.onSelectInputUnit(unit, conversionFactor)
        } else {
            _isInputError.value = true
            _errorMessage.value = "Invalid Unit"
        }
    }

    fun onSelectOutputUnit(unit: String, conversionFactor: Double) {
        val isInputValid = validateUnit(unit)
        if (isInputValid) {
            unitConverterRepository.onSelectOutputUnit(unit, conversionFactor)
        } else {
            _isInputError.value = true
            _errorMessage.value = "Invalid Unit"
        }
    }

    fun onInputValueChange(newValue: String){
        if (newValue.isNotBlank()) {
            unitConverterRepository.onInputValueChange(newValue)
        } else {
            _isInputError.value = true
            _errorMessage.value = "Invalid Input"
        }
    }

    private fun validateUnit(unit: String): Boolean {
        return UnitName.hasUnitName(unit)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as UnitConverterApp
                val repository = application.dataModule.unitConverterRepository
                UnitConverterViewModel(repository)
            }
        }
    }
}