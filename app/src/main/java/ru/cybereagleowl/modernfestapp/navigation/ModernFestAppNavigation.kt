package ru.cybereagleowl.modernfestapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.cybereagleowl.authorization.di.AuthorizationComponent
import ru.cybereagleowl.core_api.navigation.HomeScreen
import ru.cybereagleowl.core_api.navigation.Login
import ru.cybereagleowl.core_api.providers.facades.ProvidersFacade
import ru.cybereagleowl.home_screen.view.HomeScreenStub
import ru.cybereagleowl.modernfestapp.MainActivity

@Composable
fun ModernFestAppNavHost(
    navController: NavHostController,
    facade: ProvidersFacade,
    activity: MainActivity,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        //startDestination = HomeScreen.route,
        startDestination = HomeScreen.route,
        modifier = modifier
    ) {
        composable(route = Login.route) { it: NavBackStackEntry ->
            val component: AuthorizationComponent = AuthorizationComponent.create(facade, activity)
            //AuthorizationStub(component.provideString())
        }
        //homeScreenGraph(navController)
        composable(route = HomeScreen.route) {
            HomeScreenStub()
        }
    }
}