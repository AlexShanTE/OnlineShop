package com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.sid.shante.onlineshop.presentation.ui.home.emptyscreen.EmptyScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.ProfileScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.ShopScreen

@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.ShopScreen.route
    ) {
        composable(route = Screen.ShopScreen.route) {
            ShopScreen()
        }
        composable(route = Screen.FavouriteScreen.route) {
            EmptyScreen(text = "FavouriteScreen")
        }
        composable(route = Screen.ShoppingCartScreen.route) {
            EmptyScreen(text = "ShoppingCartScreen")
        }
        composable(route = Screen.ShoppingCartScreen.route) {
            EmptyScreen(text = "ShoppingCartScreen")
        }
        composable(route = Screen.MessageScreen.route) {
            EmptyScreen(text = "MessageScreen")
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object ShopScreen : Screen("ShopScreen")
    object FavouriteScreen : Screen("FavouriteScreen")
    object ShoppingCartScreen : Screen("ShoppingCartScreen")
    object MessageScreen : Screen("MessageScreen")
    object ProfileScreen : Screen("ProfileScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg}")
            }
        }
    }
}
