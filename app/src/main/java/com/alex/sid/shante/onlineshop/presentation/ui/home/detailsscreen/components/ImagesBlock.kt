package com.alex.sid.shante.onlineshop.presentation.ui.home.detailsscreen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> ImagesBlock(
    previewImageUrl: String,
    listOfPagerItems: List<T>,
    pageCount: Int,
    pagerState : PagerState,
    onAddFavouriteClick: () -> Unit,
    onShareClick: () -> Unit,
    onPreviewChanged: (Int) -> Unit
) {
    ImagePreviewWithButton(
        imageUrl = previewImageUrl,
        onAddFavouriteClick = {
            onAddFavouriteClick()
        },
        onShareClick = {
            onShareClick()
        }
    )
    Spacer(modifier = Modifier.height(35.dp))
    HorizontalPager(
        modifier = Modifier.fillMaxWidth(),
        pageCount = pageCount,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 146.dp)
    ) { page ->
        Card(
            modifier = Modifier
                .width(83.dp)
                .height(45.dp)
                .scale(
                    if (pagerState.currentPage != page) 1f
                    else 1.25f
                ),
            shape = RoundedCornerShape(6.dp),
            elevation = if (pagerState.currentPage != page) 1.dp
            else 8.dp
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = listOfPagerItems[page],
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            if (pagerState.currentPage == page) {
                onPreviewChanged(page)
            }
        }
    }
}