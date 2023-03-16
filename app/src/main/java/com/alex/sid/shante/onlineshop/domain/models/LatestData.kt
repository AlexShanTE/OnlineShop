package com.alex.sid.shante.onlineshop.domain.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LatestData(
    @SerializedName("latest")
    val latest: List<LatestItem>
)

@Serializable
data class LatestItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)