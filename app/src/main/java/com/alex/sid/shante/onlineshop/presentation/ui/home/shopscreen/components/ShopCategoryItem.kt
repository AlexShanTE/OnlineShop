package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun ShopCategoryItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
    isSelected: Boolean = false,
    onCategoryClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FloatingActionButton(
            modifier = Modifier.size(42.dp),
            backgroundColor =
            if (!isSelected) Color(0xFFEEEFF4)
            else Color.Gray,
            onClick = { onCategoryClick() }
        ) {
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = icon),
                contentDescription = "$title icon"
            )
        }
        Spacer(modifier = modifier.height(11.dp))
        Text(
            text = title,
            fontFamily = Poppins.toFontFamily(),
            fontSize = 10.sp,
            color = Color(0xFFA6A7AB)
        )
    }
}