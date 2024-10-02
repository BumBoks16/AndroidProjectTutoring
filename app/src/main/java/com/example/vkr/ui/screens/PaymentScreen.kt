package com.example.vkr.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vkr.R
import com.example.vkr.ui.theme.LightBlue
import com.example.vkr.ui.theme.TextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    val context = LocalContext.current
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
                    text = "Оплата",
                    color = Color.Black,
                    fontSize = 20.sp,
                    style = TextStyles.NormalTextStyle,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = LightBlue, shape = RoundedCornerShape(16.dp))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rubleimg),
                contentDescription = "RubleImg",
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text("Счет на оплату:")
                Text("500 Рублей")
            }
        }
        Spacer(modifier = Modifier.weight(1f)) // заполнитель пространства

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.paymentsbpimage), // замените your_image на ваш идентификатор ресурса изображения
                contentDescription = "Bottom Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data =
                                Uri.parse("https://qr.nspk.ru/AD10004F7SM1QOR38T1RNP592HT1U2MC?type=02&bank=100000000054&sum=4000&cur=RUB&crc=0B61")
                        }
                        context.startActivity(intent)
                    }.align(Alignment.BottomCenter)
            )
        }
    }
}