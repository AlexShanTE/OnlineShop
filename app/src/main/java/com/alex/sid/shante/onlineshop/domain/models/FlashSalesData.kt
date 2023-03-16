package com.alex.sid.shante.onlineshop.domain.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class FlashSalesData(
    @SerializedName("flash_sale")
    val flashSaleItem: List<FlashSaleItem>
)

@Serializable
data class FlashSaleItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double
)