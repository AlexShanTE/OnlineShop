package com.alex.sid.shante.onlineshop.presentation.ui.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.DetailsScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.ShopScreen

@Composable
fun ShopDetailsNavigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeScreen.ShopScreen.route
    ) {
        composable(route = HomeScreen.ShopScreen.route) {
            ShopScreen(navController = navHostController)
        }
        composable(route = HomeScreen.DetailsScreen.route) {
            DetailsScreen(navController = navHostController)
        }
    }
}