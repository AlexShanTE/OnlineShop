package com.alex.sid.shante.onlineshop.domain.models

data class Data(
    val categories: List<ShopCategory> = listOf(
        ShopCategory.Phones(),
        ShopCategory.Headphones(),
        ShopCategory.Games(),
        ShopCategory.Cars(),
        ShopCategory.Furniture(),
        ShopCategory.Kids()
    )
)