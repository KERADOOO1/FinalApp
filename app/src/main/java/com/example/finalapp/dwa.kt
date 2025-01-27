package com.example.finalapp


import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


@Composable
fun EkranDwa() {
    val wszystkie = remember { mutableStateOf(listOf<String>()) }
    val tekst = remember { mutableStateOf("") }

    val lewy = remember { mutableStateOf("") }
    val prawy = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .background(color = Color(17, 16, 43))
            .fillMaxSize()
    ) {
        item {
            TextField(
                modifier = Modifier
                    .height(250.dp)
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState()),
                value = tekst.value,
                onValueChange = { tekst.value = it }
            )
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            Button(onClick = {
                if (tekst.value.isNotBlank()) {

                    val c = Random.nextInt(2, 91)

                    wszystkie.value = tekst.value.split("\n")
                        .filterNot { it.isEmpty() }
                        .shuffled(Random(c))


                    val lewaList = mutableListOf<String>()
                    val prawaList = mutableListOf<String>()
                    wszystkie.value.forEachIndexed { index, item ->
                        if (index % 2 == 0) {
                            lewaList.add(item)
                        } else {
                            prawaList.add(item)
                        }
                    }
                    lewy.value = lewaList.joinToString(separator = "\n")
                    prawy.value = prawaList.joinToString(separator = "\n")
                }
            }) {
                Text(text = "Podziel")
            }
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            Row {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                Column(
                    modifier = Modifier
                        .weight(9f)
                        .background(color = Color(154, 152, 222))
                ) {
                    Box(modifier = Modifier
                        .align(Alignment.End)
                        .fillMaxSize()
                        .background(color = Color(127, 125, 195)),
                        contentAlignment = Alignment.CenterEnd)
                    {
                        Text(modifier = Modifier.padding(0.dp, 0.dp, 10.dp,0.dp),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Right,
                            text = "Drużyna 1",
                            color = Color.Red

                        )}
                    Text(
                        text = lewy.value,
                        color = Color.White
                    )

                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                Column(
                    modifier = Modifier
                        .weight(9f)
                        .background(color = Color(154, 152, 222))

                ) {
                    Box(modifier = Modifier
                        .align(Alignment.End)
                        .fillMaxSize()
                        .background(color = Color(127, 125, 195)),
                        contentAlignment = Alignment.CenterEnd)

                    {
                    Text(modifier = Modifier.padding(0.dp, 0.dp, 10.dp,0.dp),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Right,
                        text = "Drużyna 2",
                        color = Color.Red


                    )}

                    Text(
                        text = prawy.value,
                        color = Color.White
                    )

                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}
