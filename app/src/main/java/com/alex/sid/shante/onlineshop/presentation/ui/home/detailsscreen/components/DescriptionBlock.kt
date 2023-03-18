package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun DescriptionBlock(
    modifier: Modifier,
    name: String,
    price: String,
    description: String,
    rating: String,
    numberOfReviews: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            modifier = Modifier.width(186.dp),
            text = name,
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = Color(0xFF161826)
        )
        Text(
            text = "$ $price",
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = Color(0xFF161826)
        )
    }
    Spacer(modifier = Modifier.height(18.dp))
    Text(
        modifier = Modifier
            .width(230.dp)
            .height(42.dp)
            .padding(start = 24.dp),
        text = description,
        fontFamily = Poppins.toFontFamily(),
        fontSize = 9.sp,
        color = Color(0xFF808080)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .padding(start = 24.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(10.dp),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = stringResource(R.string.rating),
            tint = Color(0xFFF6C042)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = rating,
            textAlign = TextAlign.Center,
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            color = Color(0xFF161826)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "($numberOfReviews " + stringResource(R.string.reviews) + ")",
            textAlign = TextAlign.Center,
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            color = Color(0xFF808080)
        )
    }
}