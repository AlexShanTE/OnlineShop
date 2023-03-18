package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun LatestItemCard(
    modifier: Modifier = Modifier,
    category: String,
    name: String,
    price: Int,
    imageUrl: String,
    onAddClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(150.dp)
            .width(114.dp),
        shape = RoundedCornerShape(9.dp)
    ) {
        //image
        AsyncImage(
            modifier = modifier.fillMaxSize(),
            model = imageUrl,
            contentDescription = category + name
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            //Category
            Text(
                modifier = Modifier
                    .height(12.dp)
                    .width(35.dp)
                    .background(
                        color = Color(0xD9C4C4C4),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(start = 6.dp, end = 6.dp, top = 1.dp, bottom = 1.dp),
                text = category,
                textAlign = TextAlign.Center,
                fontFamily = Poppins.toFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 6.sp,
                color = Color(0xFF070604)
            )
            Spacer(modifier = Modifier.height(3.dp))
            //Name
            Text(
                modifier = Modifier
                    .height(26.dp)
                    .width(75.dp),
                text = name,
                style = TextStyle.Default.copy(
                    fontFamily = Poppins.toFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(1f, 1f),
                        blurRadius = 4f
                    )
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //Price
                Text(
                    text = "$ $price",
                    style = TextStyle.Default.copy(
                        fontFamily = Poppins.toFontFamily(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 7.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 1f),
                            blurRadius = 4f
                        )
                    )
                )
                //Button
                FloatingActionButton(
                    modifier = Modifier
                        .size(20.dp),
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    backgroundColor = Color(0xFFE5E9EF),
                    onClick = { onAddClick() }
                ) {
                    Icon(
                        modifier = Modifier.size(10.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color(0xFF545589)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LatestItemPreview() {
    LatestItemCard(
        category = "Phones",
        name = "Samsung S10",
        price = 1000,
        imageUrl = "",
        onAddClick = {}

    )
}