package com.alex.sid.shante.onlineshop.presentation.ui.home.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.components.IconWithCircleBorder


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    navController: NavController,
    onItemCLick: (BottomNavItem) -> Unit
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    val screensWithBottomBar = listOf(
        Screen.ShopScreen,
        Screen.FavouriteScreen,
        Screen.ShoppingCartScreen,
        Screen.MessageScreen,
        Screen.ProfileScreen
    )

    val bottomBarDestination = screensWithBottomBar.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(
                    RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                ),
            backgroundColor = Color.White,
            elevation = 8.dp
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry?.destination?.route
                BottomNavigationItem(
                    selected = item.route == navController.currentDestination?.route,
                    onClick = {
                        if (!selected) {
                            onItemCLick(item)
                        }
                    },
                    icon = {
                        if (selected) {
                            Column(
                                modifier = modifier,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                IconWithCircleBorder(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
//                                Text(text = item.name) add text if needed
                            }
                        } else Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = Color(0xFF909090)
                        )
                    },
                )
            }
        }
    }
}

