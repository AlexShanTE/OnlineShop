package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
fun CustomButtonWithIcon(
    painter: Painter,
    text: String,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier,
            interactionSource = NoRippleInteractionSource(),
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            ),
            onClick = {
                onButtonClick()
            }
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painter,
                contentDescription = text,
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                color = Color.Black,
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonWithIconPreview() {
    CustomButtonWithIcon(
        painter = painterResource(id = R.drawable.ic_apple),
        text = "Sign in with Google",
        onButtonClick = {}
    )
}