package dev.prabhatpandey.playflix.auth.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.prabhatpandey.playflix.auth.presentation.screens.forgotpassword.ForgotPasswordScreen
import dev.prabhatpandey.playflix.auth.presentation.screens.login.LoginScreen
import dev.prabhatpandey.playflix.auth.presentation.screens.register.RegisterScreen
import dev.prabhatpandey.playflix.core.navigation.AuthScreen
import dev.prabhatpandey.playflix.core.navigation.RootNavigation

fun NavGraphBuilder.authNavigation(
    navController: NavHostController,
    route: String = RootNavigation.AuthNav.route,
    startDestination: String = AuthScreen.Login.route
) {
    navigation(
        route = route,
        startDestination = startDestination
    ) {
        composable(AuthScreen.Login.route) { entry ->
            LoginScreen()
        }

        composable(AuthScreen.Register.route) { entry ->
            RegisterScreen()
        }

        composable(AuthScreen.ForgotPassword.route) { entry ->
            ForgotPasswordScreen()
        }

    }

}