package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.sid.shante.onlineshop.R

@Composable
fun ProfileImageWithLocation(
    modifier: Modifier = Modifier,
    imageBitmap: ImageBitmap,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .background(
                    shape = RoundedCornerShape(50),
                color = Color(0xFF4E4D4D)
                ),
            contentScale = ContentScale.Fit,
            bitmap = imageBitmap,
            contentDescription = stringResource(R.string.profile_image)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileImageWithLocationPreview() {
    ProfileImageWithLocation(
        imageBitmap = ImageBitmap.imageResource(R.drawable.avatar_dude),
    )
}