package ru.cybereagleowl.home_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.cybereagleowl.core_api.navigation.Events
import ru.cybereagleowl.core_api.navigation.HomeScreen
import ru.cybereagleowl.core_api.navigation.News
import ru.cybereagleowl.events.EventsStub
import ru.cybereagleowl.news.NewsStub

fun NavGraphBuilder.homeScreenGraph(navController: NavController) {
    navigation(startDestination = Events.route, route = HomeScreen.route) {
        composable(Events.route) { EventsStub() }
        composable(News.route) { NewsStub() }
    }
}