package com.example.clotappui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.clotappui.ui.screens.*

@Composable
fun ClotNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.OnboardingSplash.route) {

        composable(Screen.OnboardingSplash.route) {
            OnboardingSplashScreen(onNext = { navController.navigate(Screen.LoginEmail.route) {
                popUpTo(Screen.OnboardingSplash.route) { inclusive = true }
            } })


        }

        composable(Screen.LoginEmail.route) {
            LoginEmailScreen(onNext = { navController.navigate(Screen.LoginPassword.route) },
                onCreate = { navController.navigate("create_account")})
        }

        composable(Screen.LoginPassword.route) {
            LoginPasswordScreen(
                onForgotPassword = { navController.navigate(Screen.ForgotPassword.route) },
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Screen.CreateAccount.route) {
            CreateAccountScreen( onBack = { navController.popBackStack() },
                onAccountCreated = { navController.navigate(Screen.LoginEmail.route) },
                onForgotPassword = { navController.navigate(Screen.ForgotPassword.route)})
        }

        composable(Screen.ForgotPassword.route) {

            ForgotPasswordScreen( onBack = { navController.popBackStack() }
                ,onResetSent = {
                navController.navigate(Screen.PasswordResetSent.route)
            })
        }

        composable(Screen.PasswordResetSent.route) {
            PasswordResetSentScreen(onBackToLogin = {
                navController.navigate(Screen.LoginEmail.route) {
                    popUpTo(Screen.PasswordResetSent.route) { inclusive = true }
                }
            })
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}

