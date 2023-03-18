package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.ui.common.TopAppBar
import com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components.BuyingBlock
import com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components.ColorBlock
import com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components.DescriptionBlock
import com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components.ImagesBlock

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val viewModel: DetailsScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    val pagerState = rememberPagerState(initialPage = (state.details.imageUrls.size / 2).toInt())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                actions = {},
                leadingIconPainter = painterResource(id = R.drawable.ic_arrowback),
                onLeadingIconClick = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ImagesBlock(
                    previewImageUrl = state.currentImagePreview,
                    listOfPagerItems = state.details.imageUrls,
                    pageCount = state.details.imageUrls.size,
                    pagerState = pagerState,
                    onAddFavouriteClick = {
                        viewModel.makeToast(context, "On add favourite clicked")
                    },
                    onShareClick = {
                        viewModel.makeToast(context, "On share clicked")
                    },
                    onPreviewChanged = {
                        viewModel.onPreviewChanged(state.details.imageUrls[pagerState.currentPage])
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                DescriptionBlock(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    name = state.details.name,
                    price = state.details.price.toString(),
                    description = state.details.description,
                    rating = state.details.rating.toString(),
                    numberOfReviews = state.details.numberOfReviews.toString()
                )
                Spacer(modifier = Modifier.height(17.dp))
                ColorBlock(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    colorList = state.details.colors,
                    onColorClick = { hexColor ->
                        viewModel.makeToast(context, "on $hexColor color clicked")
                    }
                )
            }
            BuyingBlock(
                quantity = state.itemsQuantity ,
                totalPrice = state.totalPrice,
                onIncreaseQuantity = { viewModel.onQuantityChange(1) },
                onDecreaseQuantity = { viewModel.onQuantityChange(-1) },
                onAddToCartClick = {
                    viewModel.makeToast(context, "On add to cart clicked")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val context = LocalContext.current
    DetailsScreen(
        navController = NavController(context)
    )
}