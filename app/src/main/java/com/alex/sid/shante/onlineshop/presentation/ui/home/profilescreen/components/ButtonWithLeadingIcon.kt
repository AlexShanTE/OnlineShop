package com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.sid.shante.onlineshop.R

@Composable
fun ButtonWithLeadingIcon(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    contentDescription: String? = null,
    iconBorderColor: Color = Color(0xFFEEEFF4),
    onButtonCLicked: () -> Unit
) {
    Row(
        modifier = modifier.clickable {
            onButtonCLicked()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconWithCircleBorder(
            painter = painter,
            contentDescription = contentDescription,
            iconBorderColor = iconBorderColor
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = text,
            color = Color.Black,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonWithLeadingIconPreview() {
    ButtonWithLeadingIcon(
        painter = painterResource(id = R.drawable.ic_credit_card),
        text = "Trade store",
        onButtonCLicked = {}
    )
}