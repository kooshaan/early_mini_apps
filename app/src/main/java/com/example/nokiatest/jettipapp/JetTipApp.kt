package com.example.nokiatest.jettipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class JetTipApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(){

    Surface(color = colorScheme.background) {
    }

    Column {

        Spacer(modifier = Modifier.height(75.dp))

        MainContent()

    }
}

@Composable
fun MainContent(){
    val totalBillState = remember {
        mutableStateOf("")
    }
    val splitByState = remember {
        mutableIntStateOf(1)
    }

    val tipAmountState = remember {
        mutableDoubleStateOf(0.0)
    }
    val accompaniesNumber = IntRange(start = 1, endInclusive = 70)

    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    }
    val totalPerPersonState = remember {
        mutableDoubleStateOf(0.0)
    }
    val sliderPositionState = remember {
        mutableFloatStateOf(0.0f)
    }
    BillForm(
        validState = validState,
        sliderPosition = sliderPositionState.floatValue,
        totalBillState = totalBillState,
        splitByState = splitByState,
        tipAmountState = tipAmountState,
        range = accompaniesNumber,
        totalPerPersonState = totalPerPersonState){ theNewVal ->
        sliderPositionState.floatValue = theNewVal
    }
}

@Composable
fun BillForm(
            validState: Boolean,
            sliderPosition: Float,
             totalBillState: MutableState<String>,
             range: IntRange,
             splitByState: MutableState<Int>,
             tipAmountState: MutableState<Double>,
             totalPerPersonState: MutableState<Double>,
             modifier: Modifier = Modifier,
            onValChange: (Float) -> Unit
){


    val keyboardController =  LocalSoftwareKeyboardController.current





    val tipPercentage = (sliderPosition.times(100)).toInt()

    TopHeader(totalPerPerson = totalPerPersonState.value)

    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            InputField(
                modifier = Modifier.fillMaxWidth(),
                valueState = totalBillState,
                labelID = "Enter bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    totalPerPersonState.value = calculateTotalPerPerson(
                        totalBill = totalBillState.value.toDouble(),
                        splitBy = splitByState.value,
                        tipPercentage = tipPercentage)

                    keyboardController?.hide()
                })
            if (validState) {

                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterVertically
                        )
                    )

                    Spacer(modifier = Modifier.width(120.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Default.Delete,
                            onClick = {
                                splitByState.value =
                                    if (splitByState.value > 1) splitByState.value - 1
                                    else 1
                                totalPerPersonState.value = calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitBy = splitByState.value,
                                    tipPercentage = tipPercentage
                                )
                            }
                        )

                        Text(
                            text = "${splitByState.value}",
                            modifier = Modifier
                                .padding(start = 9.dp, end = 9.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )

                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = {
                                if (splitByState.value < range.last)
                                    splitByState.value += 1
                                totalPerPersonState.value = calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitBy = splitByState.value,
                                    tipPercentage = tipPercentage
                                )
                            }
                        )

                    }
                }

                Row(
                    modifier = Modifier.padding(horizontal = 3.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Tip",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    Spacer(modifier = Modifier.width(200.dp))

                    Text(
                        text = "$${tipAmountState.value}",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "$tipPercentage%")

                    Spacer(modifier = Modifier.height(14.dp))

                    Slider(
                        value = sliderPosition,
                        onValueChange = { newVal ->
                            onValChange(newVal)
                            tipAmountState.value =
                                totalTipCalculator(
                                    totalBillState.value.toDouble(),
                                    tipPercentage)
                            totalPerPersonState.value = calculateTotalPerPerson(
                                totalBill = totalBillState.value.toDouble(),
                                splitBy = splitByState.value,
                                tipPercentage = tipPercentage)
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        /*track = {
                            SliderDefaults.Track(rangeSliderState = RangeSliderState(
                                0f, 1f), colors = SliderColors(
                                    thumbColor = Color(0xFF000000),
                                    inactiveTrackColor = Color(0xFFAA51EE),
                                    activeTrackColor = Color(0xFFAA51EE),
                                    disabledActiveTrackColor = Color(0xFFAA51EE),
                                    inactiveTickColor = Color(0xFF430075),
                                    activeTickColor = Color(0xFF270044),
                                    disabledThumbColor = Color(0xFF471072),
                                    disabledActiveTickColor = Color(0xFFAA51EE),
                                    disabledInactiveTickColor = Color(0xFF270044),
                                    disabledInactiveTrackColor = Color(0xFF6414A2)
                                )
                                )
                        }*/
                    )

                }
            } else{
                Box(modifier = Modifier.size(55.dp)){
                    Text(text = "Sad Little Box")
                }
            }

        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Double = 134.0){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
        .padding(horizontal = 30.dp, vertical = 10.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        color = Color(0x8DE3D2F0),
    ) {
        Column(modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Each Person Share",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
            Text(text = "$${"%.2f".format(totalPerPerson)}",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp)
        }
    }
}