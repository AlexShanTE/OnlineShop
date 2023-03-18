package com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.MontserratBold
import com.alex.sid.shante.onlineshop.presentation.theme.Poppins
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.common.CustomTextField
import com.alex.sid.shante.onlineshop.presentation.ui.common.TopAppBar
import com.alex.sid.shante.onlineshop.presentation.ui.home.navigation.HomeScreen
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.FlashSaleItemCard
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.HorizontalItemPager
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.LatestItemCard
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.ProfileImageWithLocation
import com.alex.sid.shante.onlineshop.presentation.ui.home.shopscreen.components.ShopCategories

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShopScreen(
    navController: NavController
) {

    val viewModel: ShopScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(58.dp),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = MontserratBold.toFontFamily(),
                        fontSize = 20.sp,
                        maxLines = 1,
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black)) { append("Trade by ") }
                            withStyle(style = SpanStyle(color = Color(0xFF4E55D7))) { append("bata") }
                        }
                    )
                },
                actions = {
                    ProfileImageWithLocation(
                        modifier = Modifier.padding(end = 40.dp),
                        imageBitmap = ImageBitmap.imageResource(R.drawable.avatar_dude),
                    )
                },
                leadingIconPainter = painterResource(id = R.drawable.ic_menu),
                onLeadingIconClick = {
                    viewModel.makeToast(context, "on Menu clicked")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 11.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val latestItems = state.latestData?.latest
            val flashSaleItems = state.flashSalesData?.flashSales
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(R.string.location),
                    fontFamily = Poppins.toFontFamily(),
                    fontSize = 10.sp,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(2.dp))
                Icon(
                    modifier = Modifier.clickable {
                        viewModel.makeToast(context, "On change location clicked")
                    },
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = stringResource(R.string.change_location)
                )
            }
            Spacer(modifier = Modifier.height(9.dp))
            CustomTextField(
                value = state.textFieldValue,
                placeHolderText = stringResource(R.string.what_are_you_looking_for),
                backgroundColor = Color(0xFFF5F6F6),
                onValueChange = { viewModel.onSearchTextChange(it) },
                trailingIcon = {
                    if (state.textFieldValue.isEmpty())
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = stringResource(R.string.search_icon)
                        )
                    else
                        Icon(
                            modifier = Modifier.clickable { viewModel.onSearchTextChange("") },
                            imageVector = Icons.Default.Cancel,
                            contentDescription = stringResource(R.string.cancel_button)
                        )
                }
            )
            Spacer(modifier = Modifier.height(17.dp))
            ShopCategories(
                onSelectCategory = { shopCategory ->
                    viewModel.onCategorySelected(context, shopCategory)
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            if (latestItems !== null) {
                HorizontalItemPager(
                    modifier = Modifier.fillMaxWidth(),
                    title = stringResource(R.string.latest),
                    items = latestItems,
                    pageSize = PageSize.Fixed(114.dp),
                    pageSpacing = 12.dp,
                    onViewAllClick = {
                        viewModel.makeToast(context, "On view all latest clicked")
                    }
                ) { index ->
                    LatestItemCard(
                        category = latestItems[index].category,
                        name = latestItems[index].name,
                        price = latestItems[index].price,
                        imageUrl = latestItems[index].imageUrl,
                        onAddClick = {
                            viewModel.makeToast(
                                context,
                                "On add ${latestItems[index].name} clicked"
                            )
                        },
                        onCardCLick = {navController.navigate(route = HomeScreen.DetailsScreen.route)}
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (flashSaleItems !== null) {
                HorizontalItemPager(
                    modifier = Modifier.fillMaxWidth(),
                    title = stringResource(R.string.flash_sale),
                    items = flashSaleItems,
                    pageSize = PageSize.Fixed(174.dp),
                    pageSpacing = 9.dp,
                    onViewAllClick = {
                        viewModel.makeToast(context, "On view all flashsales clicked")
                    }
                )
                { index ->
                    FlashSaleItemCard(
                        modifier = Modifier
                            .height(221.dp)
                            .width(174.dp),
                        category = flashSaleItems[index].category,
                        discount = flashSaleItems[index].discount,
                        imageUrl = flashSaleItems[index].imageUrl,
                        name = flashSaleItems[index].name,
                        price = flashSaleItems[index].price,
                        onFavouriteClick = {
                            viewModel.makeToast(
                                context,
                                "on favourite ${flashSaleItems[index].name} clicked"
                            )
                        },
                        onAddClick = {
                            viewModel.makeToast(
                                context,
                                "on add ${flashSaleItems[index].name} clicked"
                            )
                        },
                        onCardClick = {navController.navigate(route = HomeScreen.DetailsScreen.route)}
                    )
                }
            }
        }
    }
}
