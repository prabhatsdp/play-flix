package dev.prabhatpandey.playflix.core.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.prabhatpandey.playflix.auth.presentation.navigation.authNavigation

@Composable
fun RootNavGraph(
    navController: NavHostController,
    startDestination: String = RootNavigation.AuthNav.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { fadeIn(tween()) },
        exitTransition = { fadeOut(tween()) },
        popEnterTransition = { fadeIn(tween()) },
        popExitTransition = { fadeOut(tween()) },
    ) {

        authNavigation(navController)

    }
}