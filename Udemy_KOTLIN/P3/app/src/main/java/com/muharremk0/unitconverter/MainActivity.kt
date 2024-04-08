package com.muharremk0.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.muharremk0.unitconverter.ui.theme.UnitConverterTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("Meters") }
    var outputunit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 32.sp,
        color = androidx.compose.ui.graphics.Color.Red
    )

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100
        outputValue = result.toString()
    }

    Column (
        modifier=Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", style = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()},
            label = { Text(text = "Enter Value")})
        Row {
            Box {
                //Input Button
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputunit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputunit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Meters")},
                        onClick = {
                            iExpanded = false
                            inputunit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Feet")},
                        onClick = {
                            iExpanded = false
                            inputunit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters")},
                        onClick = {
                            iExpanded = false
                            inputunit = "Milimeters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                //Output Button
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputunit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded= false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters")},
                        onClick = {
                            oExpanded = false
                            outputunit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Meters")},
                        onClick = {
                            oExpanded = false
                            outputunit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Feet")},
                        onClick = {
                            oExpanded = false
                            outputunit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters")},
                        onClick = {
                            oExpanded = false
                            outputunit = "Milimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: ${outputValue} ${outputunit}",
            style = MaterialTheme.typography.headlineMedium)
    }

}
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}