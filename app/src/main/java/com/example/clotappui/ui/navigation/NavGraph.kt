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
            LoginEmailScreen(navController,
                onCreate = { navController.navigate("create_account")})
        }

        composable(
            route = Screen.LoginPassword.route + "?email={email}",
            arguments = listOf(navArgument("email") { defaultValue = "" })
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            LoginPasswordScreen(
                email = email,
                onForgotPassword = { navController.navigate(Screen.ForgotPassword.route) },
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(0) { inclusive = true }
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
            HomeScreen(navController = navController)
        }
    }
}

