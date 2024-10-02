@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.vkr.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vkr.R
import com.example.vkr.ui.theme.Beige
import com.example.vkr.ui.theme.LightBlue
import com.example.vkr.ui.theme.White
import com.example.vkr.ui.theme.LightGray
import com.example.vkr.ui.theme.DarkGray

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainimg),
            contentDescription = "Main Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray)
                        .padding(vertical = 8.dp,)
                ) {
                    Text(
                        text = "Обучение",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = DarkGray,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    MenuItem(navController, "Запись на урок", "Search")
                    MenuItem(navController, "Добавление заявки", "Repetitor")
                    MenuItem(navController, "Оплата", "Payment")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightGray)
                        .padding(vertical = 8.dp,)
                ) {
                    Text(
                        text = "Разное",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = DarkGray,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 6.dp)
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    MenuItem(navController, "Заявки", "Search")
                    MenuItem(navController, "Изменение профиля", "Search")}
            }
        }
    }
}

@Composable
fun MenuItem(navController: NavController, text: String, route: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate(route) }
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = DarkGray
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow Forward",
            tint = DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}