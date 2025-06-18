package com.example.clotappui.ui.navigation


sealed class Screen(val route: String) {
    object OnboardingSplash : Screen("onboarding_splash")
    object LoginEmail : Screen("login_email")
    object LoginPassword : Screen("login_password")
    object CreateAccount : Screen("create_account")
    object ForgotPassword : Screen("forgot_password")
    object PasswordResetSent : Screen("password_reset_sent")
    object Home : Screen("home")
}