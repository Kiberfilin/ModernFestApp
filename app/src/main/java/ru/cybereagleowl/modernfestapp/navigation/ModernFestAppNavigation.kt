package ru.cybereagleowl.modernfestapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.cybereagleowl.core_api.navigation.HomeScreen
import ru.cybereagleowl.core_api.navigation.Login
import ru.cybereagleowl.home_screen.homeScreenGraph

@Composable
fun ModernFestAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen.route,
        modifier = modifier
    ) {
        composable(route = Login.route) { TODO("Сделать заглушку для логина") }
        homeScreenGraph(navController)
    }
}