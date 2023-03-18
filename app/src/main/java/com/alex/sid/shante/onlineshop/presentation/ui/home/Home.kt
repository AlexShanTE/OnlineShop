package com.alex.sid.shante.onlineshop.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.ui.home.navigation.BottomNavItem
import com.alex.sid.shante.onlineshop.presentation.ui.home.navigation.BottomNavigationBar
import com.alex.sid.shante.onlineshop.presentation.ui.home.navigation.HomeScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.navigation.HomeScreenNavigation

@Composable
fun Home(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "ShopScreen",
                        route = HomeScreen.ShopScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_home)
                    ),
                    BottomNavItem(
                        name = "FavouriteScreen",
                        route = HomeScreen.FavouriteScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_favourite)
                    ),
                    BottomNavItem(
                        name = "ShoppingCartScreen",
                        route = HomeScreen.ShoppingCartScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_shoping_cart)
                    ),
                    BottomNavItem(
                        name = "MessageScreen",
                        route = HomeScreen.MessageScreen.route,
                        icon = ImageVector.vectorResource(id = R.drawable.ic_message)
                    ),
                    BottomNavItem(
                        name = "ProfileScreen",
                        route = HomeScreen.ProfileScreen.route,
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
            HomeScreenNavigation(navHostController = navHostController)
        }
    }
}