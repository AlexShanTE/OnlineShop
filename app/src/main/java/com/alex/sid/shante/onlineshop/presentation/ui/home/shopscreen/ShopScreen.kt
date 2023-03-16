package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.FlashSaleItemCard

@Composable
fun ShopScreen() {

    val viewModel: ShopScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    viewModel.getGoods(context)

//    LazyColumn(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        state.latestData?.let {
//            items(it.latest) { item ->
//                LatestItemCard(
//                    category = item.category,
//                    name = item.name,
//                    price = item.price,
//                    imageUrl = item.imageUrl,
//                    onAddClick = { viewModel.makeToast(context, "On ADD ${item.name} clicked")}
//                )
//            }
//        }
//    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        state.flashSalesData?.let {
            items(it.flashSaleItem) { item ->
                FlashSaleItemCard(
                    category = item.category,
                    discount = item.discount,
                    imageUrl = item.imageUrl,
                    name = item.name,
                    price = item.price,
                    onAddClick = { viewModel.makeToast(context, "On ADD ${item.name} clicked") },
                    onFavouriteClick = { viewModel.makeToast(context, "On FAVOURITE ${item.name} clicked") }
                )
            }
        }
    }
}
