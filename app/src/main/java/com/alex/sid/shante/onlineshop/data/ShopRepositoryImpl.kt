package com.alex.sid.shante.onlineshop.data

import com.alex.sid.shante.onlineshop.domain.models.FlashSalesData
import com.alex.sid.shante.onlineshop.domain.models.LatestData
import com.alex.sid.shante.onlineshop.domain.repositories.ShopRepository

class ShopRepositoryImpl(
    private val api: OnlineShopApi
) : ShopRepository {
    override suspend fun getLatest(): LatestData {
        return api.getLatest()
    }

    override suspend fun getFlashSales(): FlashSalesData {
        return api.getFlashSales()
    }
}