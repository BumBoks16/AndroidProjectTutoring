package com.example.vkr.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vkr.ui.theme.Beige
import com.example.vkr.MainViewModel
import com.example.vkr.R
import com.example.vkr.entity.Record

@Composable
fun SearchScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    val search = remember { mutableStateOf("") }
    val record = mainViewModel.records

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {

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
                    text = "Поиск",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = search.value,
            onValueChange = { search.value = it },
            label = { Text("Поиск") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            trailingIcon = {
                IconButton(onClick = { mainViewModel.searchRecordsByKeyword(search.value) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            })
        Log.d("zxc", "SearchScreen:${record.value}")
        LazyColumn {
            //val examplelist = listOf(com.example.vkr.entity.Record(1,"","","",5))
            items(record.value){ item ->
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = Beige, shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.noprofileimg),
                            contentDescription = "ProfileImg",
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(item.fullName)
                            Text(item.description)
                        }
                    }
                    Text("Провожу обучение по дисциплинам: ${item.keywords}")
                    Text("Стаж: ${item.experienceYears} лет")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val item = Record(1,"qwerwqerqwer","eqwrwqerqwer","qwerqwerweqr",5)
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Beige, shape = RoundedCornerShape(16.dp))
        .padding(8.dp)) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.noprofileimg),
                contentDescription = "ProfileImg",
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(item.fullName)
                Text(item.description)
            }
        }
            Text("Провожу обучение по дисциплинам: ${item.keywords}")
            Text("Стаж: ${item.experienceYears} лет")
    }
}

fun performSearch(query: String) {
    // Здесь реализуйте логику поиска
    println("Searching for: $query")
}