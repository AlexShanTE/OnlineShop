package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alex.sid.shante.onlineshop.domain.models.Data
import com.alex.sid.shante.onlineshop.domain.models.ShopCategory

@Composable
fun ShopCategories(
    onSelectCategory: (ShopCategory?) -> Unit
) {

    var categories by remember { mutableStateOf(Data().categories) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        categories.forEach { category ->
            ShopCategoryItem(
                icon = category.icon,
                title = category.title,
                isSelected = category.isSelected,
                onCategoryClick = {
                    val newList = categories.map {
                        if (it.title === category.title)
                            it.makeCopy(isSelected = !category.isSelected)
                        else it.makeCopy(isSelected = false)
                    }
                    categories = newList
                    onSelectCategory(
                        if (categories
                                .find { it.title == category.title }?.isSelected == true
                        ) category else null
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopCategoriesPreview() {
    ShopCategories(
        onSelectCategory = {}
    )
}