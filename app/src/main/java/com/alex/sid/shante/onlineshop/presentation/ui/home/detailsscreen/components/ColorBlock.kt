package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun ColorBlock(
    modifier: Modifier = Modifier,
    colorList: List<String>,
    onColorClick: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(R.string.color),
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color(0xFF737373)
        )
        Spacer(modifier = Modifier.height(11.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(colorList.size) {
                if (colorList[it].isNotEmpty()) {
                    val hexColor = colorList[it]
                    val color = Color(android.graphics.Color.parseColor(hexColor))
                    Card(
                        modifier = Modifier
                            .padding(end = 14.dp)
                            .height(26.dp)
                            .width(34.dp)
                            .clickable {
                                onColorClick(hexColor)
                            },
                        shape = RoundedCornerShape(9.dp),
                        elevation = 4.dp,
                        backgroundColor = color,
                        border = if (color == Color.White)
                            BorderStroke(2.dp, Color.Gray)
                        else BorderStroke(0.dp, Color.Transparent),
                        content = {}
                    )
                }
            }
        }
    }
}