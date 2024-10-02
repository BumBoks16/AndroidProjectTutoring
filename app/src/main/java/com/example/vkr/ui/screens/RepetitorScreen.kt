@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.vkr.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.vkr.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vkr.MainViewModel
import com.example.vkr.entity.Record
import com.example.vkr.ui.theme.LightBlue
import com.example.vkr.ui.theme.TextStyles


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepetitorScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    val fullName = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val keywords = remember { mutableStateOf("") }
    val experienceYears = remember { mutableStateOf("") }
    val cost = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = colorResource(id = R.color.biege)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { navController.navigate("main") },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Text(
                    text = "Добавление заявки",
                    color = Color.Black,
                    fontSize = 20.sp,
                    style = TextStyles.NormalTextStyle,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = { Text("ФИО", style = TextStyles.NormalTextStyle) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Описание", style = TextStyles.NormalTextStyle) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = keywords.value,
            onValueChange = { keywords.value = it },
            label = { Text("Направление обучения", style = TextStyles.NormalTextStyle) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = experienceYears.value,
            onValueChange = { experienceYears.value = it },
            label = { Text("Стаж репетиторства", style = TextStyles.NormalTextStyle) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cost.value,
            onValueChange = { cost.value = it },
            label = { Text("Цена занятия", style = TextStyles.NormalTextStyle) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val record = Record(
                    fullName = fullName.value,
                    description = description.value,
                    keywords = keywords.value,
                    experienceYears = experienceYears.value.toIntOrNull() ?: 0, // или любое значение по умолчанию
                )
                mainViewModel.insert(record)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue,
                contentColor = Color.White
            )
        ) {
            Text("Создание заявки занятия", style = TextStyles.NormalTextStyle)
        }
    }
}