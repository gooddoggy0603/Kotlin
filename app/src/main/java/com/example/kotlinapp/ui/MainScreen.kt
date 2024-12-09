package com.kotlinapp.ui

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlinapp.viewmodel.MealViewModel
import com.yourpackage.ui.HomeScreen
import com.yourpackage.ui.MealDetailScreen
import androidx.navigation.NavHostController
import com.yourpackage.ui.MealListScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun MainScreen(viewModel: MealViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate("home") }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "List") },
                    label = { Text("List") },
                    selected = false,
                    onClick = { navController.navigate("list") }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen()
            }
            composable("list") {
                val meals by viewModel.meals.collectAsState()
                MealListScreen(meals = meals) { meal ->
                    navController.navigate("detail/${meal.idMeal}")
                }
            }
            composable("detail/{mealId}") { backStackEntry ->
                val mealId = backStackEntry.arguments?.getString("mealId")
                val meal = viewModel.meals.value.find { it.idMeal == mealId }
                meal?.let { MealDetailScreen(it) }
            }
        }
    }
}
