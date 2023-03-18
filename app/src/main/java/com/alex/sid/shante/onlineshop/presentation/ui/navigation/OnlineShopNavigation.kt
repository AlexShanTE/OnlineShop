package com.alex.sid.shante.onlineshop.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen.LoginScreen
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen.SignUpScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.Home

@Composable
fun OnlineShopNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthorizationScreen.SignUpScreen.route
    ) {
        authGraph(navController)
        composable(route = "Home") {
            val navHostController = rememberNavController()
            Home(navHostController = navHostController)
        }
    }
}

fun NavGraphBuilder.authGraph(navController:NavHostController) {
    composable(route = AuthorizationScreen.SignUpScreen.route) {
        SignUpScreen(navController = navController)
    }
    composable(route = AuthorizationScreen.LoginScreen.route) {
        LoginScreen(navController = navController)
    }
}

sealed class AuthorizationScreen(val route: String) {
    object SignUpScreen : AuthorizationScreen(route = "SignUp")
    object LoginScreen : AuthorizationScreen(route = "Login")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

