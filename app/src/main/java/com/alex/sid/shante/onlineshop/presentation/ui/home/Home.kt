package com.alex.sid.shante.onlineshop.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation.BottomNavItem
import com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation.BottomNavigationBar
import com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation.Navigation
import com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation.Screen

@Composable
fun Home() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "ShopScreen",
                        route = Screen.ShopScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_home)
                    ),
                    BottomNavItem(
                        name = "FavouriteScreen",
                        route = Screen.FavouriteScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_favourite)
                    ),
                    BottomNavItem(
                        name = "ShoppingCartScreen",
                        route = Screen.ShoppingCartScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_shoping_cart)
                    ),
                    BottomNavItem(
                        name = "MessageScreen",
                        route = Screen.MessageScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_message)
                    ),
                    BottomNavItem(
                        name = "ProfileScreen",
                        route = Screen.ProfileScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_profile)
                    )
                ),
                navController = navHostController,
                onItemCLick = { bottomNavItem: BottomNavItem ->
                    navHostController.navigate(bottomNavItem.route)
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Navigation(navHostController = navHostController)
        }
    }
}