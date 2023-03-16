package com.alex.sid.shante.onlineshop.data

import com.alex.sid.shante.onlineshop.domain.models.FlashSalesData
import com.alex.sid.shante.onlineshop.domain.models.LatestData
import retrofit2.http.GET

interface OnlineShopApi {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest() : LatestData

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSales() : FlashSalesData

}