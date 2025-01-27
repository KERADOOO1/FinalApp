package com.example.finalapp



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import kotlin.random.Random





@Composable

fun EkranJeden() {
    val c  = remember{ mutableIntStateOf(5) }
    val wynik  = remember{ mutableStateOf("")}
    Column(modifier = Modifier
        .background(color = Color(17, 16, 43))
        .fillMaxSize()

    ) {
        val mniejsza = remember { mutableStateOf("") }
        val wieksza = remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {


            Spacer(
                modifier = Modifier
                    .weight(1f)

            )
            TextField(
                value = mniejsza.value,
                singleLine = true,
                onValueChange = { if (it.isDigitsOnly()) mniejsza.value = it },
                modifier = Modifier.weight(9f),
                label = { Text("Minimum") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),

            )
            Spacer(
                modifier = Modifier
                    .weight(1f)

            )
            TextField(
                value = wieksza.value,
                singleLine = true,
                onValueChange = { if (it.isDigitsOnly()) wieksza.value = it },
                modifier = Modifier.weight(9f),
                label = { Text("Maximum") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),

                )
            Spacer(
                modifier = Modifier
                    .weight(1f)

            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Row(modifier = Modifier
            .wrapContentSize(Center)
            .fillMaxWidth()
            .wrapContentWidth()

        ){
            Box(modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .border(6.dp, color = Color(77, 75, 142), shape = RoundedCornerShape(30.dp))
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color.LightGray),
                contentAlignment = Center,

            ){
            Text(textAlign = TextAlign.Center,
                fontSize = 30.sp,
                text = "${c.intValue}",
                color = Color.Black)
        }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .wrapContentSize(Center)
            .fillMaxWidth()
            .wrapContentWidth()){
            Button(onClick = {
                losowanie(high=wieksza.value,low=mniejsza.value, c = c, result = wynik)
            }) {
                Text(textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    text = "Losuj")
            }

        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier
            .wrapContentSize(Center)
            .fillMaxWidth()
            .wrapContentWidth()){
            Text(textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White,
                text = wynik.value
            )
        }
    }
}



fun losowanie (low: String, high: String, c: MutableState<Int>, result: MutableState<String>){
    CoroutineScope(Dispatchers.Main).launch {
        val min = low.toIntOrNull()
        val max = high.toIntOrNull()
        if (min == null || max == null) {
            result.value= "Jedna z liczb jest pusta"
        } else {
            if (max <= min) {
                result.value= "Maximum musi być większe od minimum"
            } else {
                for (i in 1..10) {
                    c.value = Random.nextInt(min, max+1)
                    delay(100)
                }
                val temp1 =c.value.toString()
                val temp2 = "Wylosowana liczba to:"
                result.value= "$temp2 $temp1"

            }

        }
    }
}

