package dev.prabhatpandey.playflix.core.navigation

sealed class RootNavigation(open val route: String) {
    object AuthNav: RootNavigation("auth_nav")
    object MainNav: RootNavigation("main_nav")
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("login_screen")
    object Register: AuthScreen("register_screen")
    object ForgotPassword: AuthScreen("forgot_pwd_screen")
}

sealed class AppScreen(val route: String) {
    object Home: AppScreen("home_screen")
}

