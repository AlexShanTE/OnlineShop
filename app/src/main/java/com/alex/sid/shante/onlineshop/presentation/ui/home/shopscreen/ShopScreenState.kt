package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import com.alex.sid.shante.onlineshop.domain.models.FlashSalesData
import com.alex.sid.shante.onlineshop.domain.models.LatestData
import com.alex.sid.shante.onlineshop.domain.models.ShopCategory

data class ShopScreenState(
    val textFieldValue: String = "",
    val selectedCategory: ShopCategory? = null,
    val latestData: LatestData? = null,
    val flashSalesData: FlashSalesData? = null
)
