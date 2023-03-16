package com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.common.CustomTextField

@Composable
fun LoginScreen(
    navController: NavController,
    userLogin: String?
) {


    println("USER LOGIN OUTSIDE $userLogin")

    if (userLogin!== null) {
        println("USER LOGIN IS $userLogin")
        // todo navigate page1
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val viewModel: LoginViewModel = hiltViewModel()
        val state by viewModel.state.collectAsState()
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.welcome_back),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(60.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.login,
            onValueChange = { viewModel.onLoginChanged(it) },
            isError = !state.isLoginValid,
            placeHolderText = stringResource(R.string.first_name),
        )
        Spacer(modifier = Modifier.height(35.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            isValueVisible = state.isPasswordShowed,
            isError = !state.isPasswordValid,
            trailingIcon = {
                IconButton(
                    onClick = { viewModel.changePasswordVisibility() }
                ) {
                    if (state.isPasswordShowed) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye_off),
                            contentDescription = null
                        )
                    }

                }
            },
            placeHolderText = stringResource(R.string.password),
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .padding(horizontal = 44.dp),
            onClick = {
                if (viewModel.isValidFields(context))
                    viewModel.login(
                        context,
                        login = state.login,
                        password = state.password
                    )
            },
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = stringResource(R.string.login))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    val context = LocalContext.current
    LoginScreen(
        navController = NavController(context),
        userLogin = null
    )
}