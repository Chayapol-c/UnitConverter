package com.example.unitconverter

import androidx.compose.foundation.layout.Arrangement
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.SelectOption

@Composable
fun UnitConverterScreen(viewModel: UnitConverterViewModel = viewModel()) {
    var inputValue by viewModel.inputValue
    val outputValue by viewModel.outputValue
    val inputUnit by viewModel.inputUnit
    val outputUnit by viewModel.outputUnit
    val iExpanded by viewModel.iExpanded
    val oExpanded by viewModel.oExpanded

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 32.sp,
        color = Color.Red
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Text(
            text = "Unit Converter",
            style = customTextStyle
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                viewModel.convertUnits()
            },
            label = {
                Text(text = "Enter Value=")
            })
        Row {
            SelectOption(
                isExpand = iExpanded,
                onExpandedChange = {
                    viewModel.iExpanded.value = it
                },
                unit = inputUnit,
                onSelectUnit = { unit, factor ->
                    viewModel.onSelectInputUnit(unit, factor)
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            SelectOption(
                isExpand = oExpanded,
                onExpandedChange = {
                    viewModel.oExpanded.value = it
                },
                unit = outputUnit,
                onSelectUnit = { unit, factor ->
                    viewModel.onSelectOutputUnit(unit, factor)
                }
            )
        }
        Text(
            text = "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}