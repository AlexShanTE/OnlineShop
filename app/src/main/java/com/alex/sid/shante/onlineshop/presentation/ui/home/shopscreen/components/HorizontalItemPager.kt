package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> HorizontalItemPager(
    modifier: Modifier = Modifier,
    title: String,
    items: List<T>,
    pageSize: PageSize,
    pageSpacing: Dp,
    onViewAllClick: () -> Unit,
    content: @Composable ((Int) -> Unit)
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontFamily = Poppins.toFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF070604)
            )
            Text(
                modifier = Modifier.clickable {
                    onViewAllClick()
                },
                text = stringResource(R.string.view_all),
                fontFamily = Poppins.toFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Color(0xFF808080)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalPager(
            modifier = modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            pageCount = items.size,
            pageSize = pageSize,
            pageSpacing = pageSpacing
        ) { index ->
            content(index)
        }
    }
}