package com.example.vkr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vkr.ui.theme.VKRTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkr.ui.screens.LoginScreen
import com.example.vkr.ui.screens.MainScreen
import com.example.vkr.ui.screens.RegisterScreen
import com.example.vkr.ui.screens.SearchScreen
import com.example.vkr.ui.screens.RepetitorScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKRTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController) }
        composable("register") { RegisterScreen(navController = navController) }
        composable("main") { MainScreen(navController = navController) }
        composable("search") { SearchScreen(navController = navController) }
        composable("repetitor") { RepetitorScreen(navController = navController) }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview(mainViewModel: MainViewModel = hiltViewModel()) {
//    VKRTheme {
//        AppNavigation()
//    }
//}