package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components

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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins

@Composable
fun BuyingBlock(
    modifier: Modifier = Modifier,
    quantity: Int,
    totalPrice: String,
    onIncreaseQuantity: () -> Unit,
    onDecreaseQuantity: () -> Unit,
    onAddToCartClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(117.dp),
        backgroundColor = Color(0xFF181726),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                ),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                QuantityBLock(
                    modifier = Modifier,
                    quantity = quantity,
                    onIncreaseQuantity = { onIncreaseQuantity() },
                    onDecreaseQuantity = { onDecreaseQuantity() }
                )
                Button(
                    modifier = Modifier
                        .height(44.dp)
                        .width(170.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4E55D7)),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        onAddToCartClick()
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$$totalPrice",
                            fontFamily = Poppins.toFontFamily(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.sp,
                            color = Color(0xFF99A0FF)
                        )
                        Text(
                            text = stringResource(R.string.add_to_cart),
                            fontFamily = Poppins.toFontFamily(),
                            letterSpacing = 0.sp,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuantityBLock(
    modifier: Modifier = Modifier,
    quantity: Int,
    onIncreaseQuantity: () -> Unit,
    onDecreaseQuantity: () -> Unit
) {
    Column(
        modifier = modifier.padding(bottom = 3.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.quantity),
            fontFamily = Poppins.toFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 9.sp,
            color = Color(0xFF808080)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .background(
                        color = Color(0xFF4E55D7),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(22.dp)
                    .width(38.dp),
                enabled = quantity > 1,
                onClick = { onDecreaseQuantity() }
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Plus one",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = quantity.toString(),
                fontFamily = Poppins.toFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                color = Color(0xFFFFFFFF)
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                modifier = Modifier
                    .background(
                        color = Color(0xFF4E55D7),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(22.dp)
                    .width(38.dp),
                onClick = { onIncreaseQuantity() }
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "Minus one",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuantityBLockPreview() {
    QuantityBLock(
        quantity = 10,
        onIncreaseQuantity = {},
        onDecreaseQuantity = {}
    )
}

@Preview(showBackground = true)
@Composable
fun BuyingBlockPreview() {
    BuyingBlock(
        totalPrice = "1000",
        quantity = 10,
        onIncreaseQuantity = {},
        onDecreaseQuantity = {},
        onAddToCartClick = {}
    )
}