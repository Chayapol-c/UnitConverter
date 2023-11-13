package com.example.unitconverter.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectOption(
    isExpand: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    unit: String,
    onSelectUnit: (String, Double) -> Unit
) {
    Box {
        Button(onClick = { onExpandedChange(true) }) {
            Text(text = unit)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "arrow down")
        }
        DropdownMenu(expanded = isExpand, onDismissRequest = { onExpandedChange(false) }) {
            DropdownMenuItem(
                text = { Text(text = "Centimeters") },
                onClick = {
                    onSelectUnit("Centimeters", 0.01)
                })
            DropdownMenuItem(
                text = { Text(text = "Meters") },
                onClick = {
                    onSelectUnit("Meters", 1.00)
                })
            DropdownMenuItem(
                text = { Text(text = "Feet") },
                onClick = {
                    onSelectUnit("Feet", 0.3048)
                })
            DropdownMenuItem(
                text = { Text(text = "Millimeters") },
                onClick = {
                    onSelectUnit("Millimeters", 0.001)
                })
        }
    }
}