package com.alex.sid.shante.onlineshop.domain.models

import androidx.annotation.DrawableRes
import com.alex.sid.shante.onlineshop.OnlineShopApp
import com.alex.sid.shante.onlineshop.R

sealed class ShopCategory(
    open val title: String,
    open val isSelected: Boolean = false,
    open val icon: Int
) {

    fun makeCopy(
        title: String = this.title,
        isSelected: Boolean = this.isSelected,
        icon: Int = this.icon
    ): ShopCategory {
        return when (this) {
            is Phones -> copy(title = title, isSelected = isSelected, icon = icon)
            is Headphones -> copy(title = title, isSelected = isSelected, icon = icon)
            is Games -> copy(title = title, isSelected = isSelected, icon = icon)
            is Cars -> copy(title = title, isSelected = isSelected, icon = icon)
            is Furniture -> copy(title = title, isSelected = isSelected, icon = icon)
            is Kids -> copy(title = title, isSelected = isSelected, icon = icon)
        }
    }

    data class Phones(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.phones),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_phones
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)

    data class Headphones(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.headphones),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_headphones
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)

    data class Games(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.games),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_games
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)

    data class Cars(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.cars),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_cars
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)

    data class Furniture(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.furniture),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_furniture
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)

    data class Kids(
        override val title: String = OnlineShopApp.appContext.get()!!.getString(R.string.kids),
        override val isSelected: Boolean = false,
        @DrawableRes override val icon: Int = R.drawable.ic_category_kids
    ) : ShopCategory(title = title, isSelected = isSelected, icon = icon)
}