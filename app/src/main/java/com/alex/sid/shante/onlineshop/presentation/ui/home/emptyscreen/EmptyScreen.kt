package com.alex.sid.shante.onlineshop.presentation.ui.home.emptyscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.MontserratBold
import com.alex.sid.shante.onlineshop.presentation.ui.common.TopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    text: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = MontserratBold.toFontFamily(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        maxLines = 1,
                        text = text
                    )
                },
                actions = {},
                leadingIconPainter = painterResource(id = R.drawable.ic_arrow_left),
                onLeadingIconClick = { navController.popBackStack() }
            )
        }
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, fontSize = 20.sp)
        }
    }
}