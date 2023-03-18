package com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.sid.shante.onlineshop.R

@Composable
fun IconWithCircleBorder(
    modifier: Modifier = Modifier,
    painter:Painter? = null,
    imageVector: ImageVector? = null,
    contentDescription: String? = null,
    iconBorderColor: Color = Color(0xFFEEEFF4)
) {
    Surface(
        modifier = modifier.size(40.dp),
        shape = CircleShape,
        color = iconBorderColor,
        elevation = 2.dp
    ) {
        Box(
            modifier = modifier.size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            if (painter !== null) {
                Icon(
                    painter = painter,
                    contentDescription = contentDescription
                )
            }
            if (imageVector!== null) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = contentDescription
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    IconWithCircleBorder(
        painter = painterResource(id = R.drawable.ic_restore_purchase)
    )
}