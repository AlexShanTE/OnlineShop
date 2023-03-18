package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen

import com.alex.sid.shante.onlineshop.domain.models.ItemDetails

data class DetailsScreenState(
    val details: ItemDetails = ItemDetails(
        colors = listOf(""),
        description = "",
        imageUrls = listOf(""),
        name = "",
        numberOfReviews = 0,
        price = 0,
        rating = 0.0
    ),
    val currentImagePreview: String = "",
    val itemsQuantity: Int = 3,
    val totalPrice: String = ""
)