package com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
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
fun ButtonWithIcons(
    painter: Painter,
    text: String,
    textInsteadTrailingIcon: String? = null,
    isArrowShowed: Boolean = true,
    onButtonClick: () -> Unit,
    onArrowClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonWithLeadingIcon(
                modifier = Modifier.weight(1f),
                painter = painter,
                text = text,
                onButtonCLicked = {
                    onButtonClick()
                }
            )
            if (textInsteadTrailingIcon !== null) {
                Text(
                    text = textInsteadTrailingIcon,
                    style = MaterialTheme.typography.button
                )
            } else {
                if (isArrowShowed) {
                    Icon(
                        modifier = Modifier
                            .size(10.dp)
                            .clickable {
                                onArrowClick()
                            },
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = text,
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonWithIconPreview() {
    ButtonWithIcons(
        painter = painterResource(id = R.drawable.ic_credit_card),
        text = "Trade store",
        textInsteadTrailingIcon = null,
        onButtonClick = {},
        onArrowClick = {}
    )
}