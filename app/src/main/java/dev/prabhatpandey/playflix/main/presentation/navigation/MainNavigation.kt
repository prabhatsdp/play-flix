package dev.prabhatpandey.playflix.main.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.prabhatpandey.playflix.core.navigation.AppScreen
import dev.prabhatpandey.playflix.core.navigation.AuthScreen
import dev.prabhatpandey.playflix.core.navigation.RootNavigation

fun NavGraphBuilder.authNavigation(
    navController: NavHostController,
    route: String = RootNavigation.MainNav.route,
    startDestination: String = AppScreen.Home.route
) {
    navigation(
        route = route,
        startDestination = startDestination
    ) {
        composable(AppScreen.Home.route) {

        }
    }


}