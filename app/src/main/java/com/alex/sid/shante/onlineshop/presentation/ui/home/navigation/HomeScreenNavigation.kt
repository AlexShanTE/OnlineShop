package com.alex.sid.shante.onlineshop.presentation.ui.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.sid.shante.onlineshop.presentation.ui.home.emptyscreen.EmptyScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.ProfileScreen

@Composable
fun HomeScreenNavigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeScreen.ShopScreen.route
    ) {
        composable(route = HomeScreen.ShopScreen.route) {
            val navHost = rememberNavController()
            ShopDetailsNavigation(navHostController = navHost)
        }
        composable(route = HomeScreen.FavouriteScreen.route) {
            EmptyScreen(
                navController = navHostController,
                text = "FavouriteScreen"
            )
        }
        composable(route = HomeScreen.ShoppingCartScreen.route) {
            EmptyScreen(
                navController = navHostController,
                text = "ShoppingCartScreen"
            )
        }
        composable(route = HomeScreen.ShoppingCartScreen.route) {
            EmptyScreen(
                navController = navHostController,
                text = "ShoppingCartScreen"
            )
        }
        composable(route = HomeScreen.MessageScreen.route) {
            EmptyScreen(
                navController = navHostController,
                text = "MessageScreen"
            )
        }
        composable(route = HomeScreen.ProfileScreen.route) {
            ProfileScreen(navController = navHostController)
        }
    }
}

sealed class HomeScreen(val route: String) {
    object ShopScreen : HomeScreen("ShopScreen")
    object DetailsScreen : HomeScreen("DetailsScreen")
    object FavouriteScreen : HomeScreen("FavouriteScreen")
    object ShoppingCartScreen : HomeScreen("ShoppingCartScreen")
    object MessageScreen : HomeScreen("MessageScreen")
    object ProfileScreen : HomeScreen("ProfileScreen")
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg}")
            }
        }
    }
}
