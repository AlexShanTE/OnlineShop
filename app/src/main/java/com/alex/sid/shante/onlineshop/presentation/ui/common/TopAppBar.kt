package com.alex.sid.shante.onlineshop.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alex.sid.shante.onlineshop.R

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    backgroundColor: Color = Color.Transparent,
    leadingIconPainter: Painter? = null,
    title: @Composable () -> Unit,
    actions: @Composable () -> Unit,
    onLeadingIconClick: () -> Unit,
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        elevation = elevation,
        modifier = modifier.fillMaxWidth()
    ) {
        //TopAppBar Content
        Box {
            //Navigation Icon
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIconPainter !== null) {
                    IconButton(
                        onClick = { onLeadingIconClick() },
                        enabled = true,
                    ) {
                        Icon(
                            painter = leadingIconPainter,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            }
            //Title
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                title()
            }
            //actions
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                actions()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(
        leadingIconPainter = painterResource(id = R.drawable.ic_help),
        title = { Text(text = "Text") },
        actions = {
            Box(
                Modifier
                    .size(50.dp)
                    .background(Color.Black)) {

            }
        }
    ) {
    }
}