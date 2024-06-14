@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.vkr.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vkr.ui.theme.Beige
import com.example.vkr.ui.theme.LightBlue
import com.example.vkr.ui.theme.h6
import com.example.vkr.R


@Composable
fun LoginScreen(navController: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.loginimg),
            contentDescription = "Login Image",
            modifier = Modifier.size(400.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("main") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LightBlue, contentColor = Color.White), // Новые цвета кнопки
        ) {
            Text("Войти")
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Нет аккаунта? ",
                color = Color.Gray,
            )
            Text(
                text = "Зарегистрироваться",
                color = LightBlue,
                modifier = Modifier.clickable { navController.navigate("register") }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}