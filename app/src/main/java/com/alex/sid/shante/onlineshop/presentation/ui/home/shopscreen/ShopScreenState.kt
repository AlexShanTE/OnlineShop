package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import com.alex.sid.shante.onlineshop.domain.models.FlashSalesData
import com.alex.sid.shante.onlineshop.domain.models.LatestData

data class ShopScreenState(
    val textFieldValue: String = "",
    val latestData: LatestData? = null,
    val flashSalesData: FlashSalesData? = null
)
