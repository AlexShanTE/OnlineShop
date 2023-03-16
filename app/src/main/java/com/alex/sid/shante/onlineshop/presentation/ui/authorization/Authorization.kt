package com.alex.sid.shante.onlineshop.presentation.ui.authorization

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen.LoginScreen
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen.SignUpScreen

@Composable
fun Authorization() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignUpScreen.route) {
        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(
            route = Screen.LoginScreen.route + "/{userLogin}",
            arguments = listOf(
                navArgument("userLogin") {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {  entry ->
            LoginScreen(
                navController = navController,
                userLogin = entry.arguments?.getString("userLogin")
            )
        }
    }
}

sealed class Screen(val route: String) {
    object SignUpScreen : Screen(route = "SignUp")
    object LoginScreen : Screen(route = "Login")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}