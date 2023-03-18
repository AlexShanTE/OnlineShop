package com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.Montserrat
import com.alex.sid.shante.onlineshop.presentation.theme.MontserratBold
import com.alex.sid.shante.onlineshop.presentation.ui.common.TopAppBar
import com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen.components.ButtonWithIcons

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val viewModel = ProfileScreenViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = MontserratBold.toFontFamily(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        maxLines = 1,
                        text = stringResource(R.string.profile)
                    )
                },
                actions = {},
                leadingIconPainter = painterResource(id = R.drawable.ic_arrow_left),
                onLeadingIconClick = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(60.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.avatar_dude),
                contentDescription = "Avatar"
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = Modifier.clickable {
                    //todo upload photo
                    viewModel.makeToast(context, "On change photo clicked")
                },
                text = stringResource(R.string.change_photo),
                fontFamily = Montserrat.toFontFamily(),
                fontSize = 8.sp,
                color = Color(0xFF808080)

            )
            Spacer(modifier = Modifier.height(17.dp))
            Text(
                fontFamily = MontserratBold.toFontFamily(),
                fontSize = 18.sp,
                color = Color.Black,
                maxLines = 1,
                text = "Satria Adhi Pradana"
            )
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(290.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    viewModel.makeToast(context, "On Upload item clicked")
                }
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.upload_item)
                        )
                    }
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 52.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_upload),
                            contentDescription = stringResource(R.string.upload_item)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_credit_card),
                text = stringResource(R.string.trade_store),
                onButtonClick = { viewModel.makeToast(context, "On trade store button clicked") },
                onArrowClick = { viewModel.makeToast(context, "On trade store ARROW clicked") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_credit_card),
                text = stringResource(R.string.balance),
                textInsteadTrailingIcon = "$ 1593",
                onButtonClick = { viewModel.makeToast(context, "On balance button clicked") },
                onArrowClick = { viewModel.makeToast(context, "On balance ARROW clicked") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_credit_card),
                text = stringResource(R.string.trade_history),
                onButtonClick = { viewModel.makeToast(context, "On trade history button clicked") },
                onArrowClick = { viewModel.makeToast(context, "On trade history ARROW clicked") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_restore_purchase),
                text = stringResource(R.string.restore_purchase),
                onButtonClick = {
                    viewModel.makeToast(
                        context,
                        "On restore purchase button clicked"
                    )
                },
                onArrowClick = { viewModel.makeToast(context, "On restore purchase ARROW clicked") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_help),
                text = stringResource(R.string.help),
                isArrowShowed = false,
                onButtonClick = { viewModel.makeToast(context, "On help button clicked") },
                onArrowClick = {}
            )
            Spacer(modifier = Modifier.height(25.dp))
            ButtonWithIcons(
                painter = painterResource(id = R.drawable.ic_logout),
                text = stringResource(R.string.log_out),
                isArrowShowed = false,
                onButtonClick = { navController.navigate("SignUp") },
                onArrowClick = {}
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val context = LocalContext.current
    ProfileScreen(navController = NavController(context))
}