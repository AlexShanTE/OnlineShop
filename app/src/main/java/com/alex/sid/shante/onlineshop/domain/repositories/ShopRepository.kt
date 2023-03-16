package com.alex.sid.shante.onlineshop.domain.repositories

import com.alex.sid.shante.onlineshop.domain.models.FlashSalesData
import com.alex.sid.shante.onlineshop.domain.models.LatestData

interface ShopRepository {
    suspend fun getLatest(): LatestData
    suspend fun getFlashSales(): FlashSalesData
}