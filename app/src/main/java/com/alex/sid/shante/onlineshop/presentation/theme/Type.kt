package com.alex.sid.shante.onlineshop.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.R

val Montserrat = Font(R.font.montserrat, FontWeight.Normal)
val MontserratBold = Font(R.font.montserrat_bold, FontWeight.Bold)
val Poppins = Font(R.font.poppins, FontWeight.Normal)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Montserrat.toFontFamily(),
        fontSize = 11.sp
    ),
    h4 = TextStyle(
        fontFamily = MontserratBold.toFontFamily(),
        fontSize = 26.sp
    ),
    button = TextStyle(
        fontFamily = MontserratBold.toFontFamily(),
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Montserrat.toFontFamily(),
        fontSize = 12.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Montserrat.toFontFamily(),
        fontSize = 10.sp
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)