package com.example.unitconverter.data

data class UnitConverterModel(
    var inputValue: String = "",
    var outputValue: String = "",
    var inputUnit: String = "",
    var outputUnit: String = "",
    var iExpanded: Boolean = false,
    var oExpanded: Boolean = false,
    var inputConversionFactor: Double = 0.0,
    var outputConversionFactor: Double = 0.0,

)
