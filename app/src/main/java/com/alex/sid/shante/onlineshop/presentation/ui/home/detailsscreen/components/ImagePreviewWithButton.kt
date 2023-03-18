package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alex.sid.shante.onlineshop.R

@Composable
fun ImagePreviewWithButton(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    onAddFavouriteClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            modifier = modifier
                .height(280.dp)
                .width(328.dp)
                .offset(x = (-5).dp)
                .clip(shape = RoundedCornerShape(9.dp)),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.item_details_preview)
        )
        Column(
            modifier = modifier
                .offset(y = 156.dp, x = (-26).dp)
                .height(95.dp)
                .width(42.dp)
                .background(
                    color = Color(0xFFE5E9EF),
                    shape = RoundedCornerShape(14.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = modifier.size(15.dp),
                onClick = { onAddFavouriteClick() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favourite),
                    contentDescription = "Add to favourite",
                    tint = Color(0xFF545589)
                )
            }
            Spacer(modifier = modifier.height(17.dp))
            Divider(
                modifier = modifier.width(12.dp),
                color = Color(0xFF545589),
                thickness = 1.dp
            )
            Spacer(modifier = modifier.height(17.dp))
            IconButton(
                modifier = modifier.size(15.dp),
                onClick = { onShareClick() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = "Share",
                    tint = Color(0xFF545589)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreviewWithButtonPreview() {
    ImagePreviewWithButton(
        imageUrl = "",
        onAddFavouriteClick = {},
        onShareClick = {}
    )
}