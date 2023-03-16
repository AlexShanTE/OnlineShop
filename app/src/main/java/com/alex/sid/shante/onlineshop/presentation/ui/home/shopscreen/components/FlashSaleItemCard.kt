package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun FlashSaleItemCard(
    modifier: Modifier = Modifier,
    category: String,
    discount: Int,
    imageUrl: String,
    name: String,
    price: Double,
    onFavouriteClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(221.dp)
            .width(174.dp),
        shape = RoundedCornerShape(11.dp)
    ) {
        //image
        AsyncImage(
            modifier = modifier.fillMaxSize(),
            model = imageUrl,
//            contentScale = ContentScale.Crop,
            contentDescription = category + name
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(25.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.dude_png),
                    contentDescription = "Dude")
                //discount
                Text(
                    modifier = Modifier
                        .height(18.dp)
                        .width(49.dp)
                        .background(
                            color = Color(0xFFF93A3A),
                            shape = RoundedCornerShape(9.dp)
                        )
                        .padding(start = 4.dp, end = 4.dp, top = 1.dp, bottom = 1.dp),
                    text = "$discount% off",
                    textAlign = TextAlign.Center,
                    fontFamily = Poppins.toFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color(0xFFFFFFFF)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            //Category
            Text(
                modifier = Modifier
                    .height(17.dp)
                    .width(50.dp)
                    .background(
                        color = Color(0xD9C4C4C4),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(start = 8.dp, end = 8.dp, top = 1.dp, bottom = 1.dp),
                text = category,
                textAlign = TextAlign.Center,
                fontFamily = Poppins.toFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                color = Color(0xFF070604)
            )
            Spacer(modifier = Modifier.height(3.dp))
            //Name
            Text(
                modifier = Modifier
                    .height(36.dp)
                    .width(87.dp),
                text = name,
                style = TextStyle.Default.copy(
                    fontFamily = Poppins.toFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
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
                        fontSize = 10.sp,
                        color = Color.White,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 1f),
                            blurRadius = 4f
                        )
                    )
                )
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //favouriteButton
                    FloatingActionButton(
                        modifier = Modifier
                            .size(28.dp),
                        elevation = FloatingActionButtonDefaults.elevation(0.dp),
                        backgroundColor = Color(0xFFE5E9EF),
                        onClick = { onFavouriteClick() }
                    ) {
                        Icon(
                            modifier = Modifier.size(14.dp),
                            painter = painterResource(id = R.drawable.ic_favourite),
                            contentDescription = "Add",
                            tint = Color(0xFF545589)
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    //AddButton
                    FloatingActionButton(
                        modifier = Modifier
                            .size(35.dp),
                        elevation = FloatingActionButtonDefaults.elevation(0.dp),
                        backgroundColor = Color(0xFFE5E9EF),
                        onClick = { onAddClick() }
                    ) {
                        Icon(
                            modifier = Modifier.size(17.dp),
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color(0xFF545589)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlashSaleItemPreview() {
    FlashSaleItemCard(
        category = "Kids",
        discount = 30,
        imageUrl = "",
        name = "New balance sneakers",
        price = 33.00,
        onFavouriteClick = { },
        onAddClick = {}
    )
}
