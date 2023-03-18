package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.alex.sid.shante.onlineshop.domain.models.User
import com.alex.sid.shante.onlineshop.presentation.theme.LogInColor
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.common.CustomTextField
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen.components.CustomButtonWithIcon
import com.alex.sid.shante.onlineshop.presentation.ui.navigation.AuthorizationScreen
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val viewModel: SignUpViewModel = hiltViewModel()
        val state by viewModel.state.collectAsState()
        val context = LocalContext.current
        val scope = rememberCoroutineScope()

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.sign_up),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(60.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.login,
            isError = !state.isLoginValid,
            placeHolderText = stringResource(R.string.login),
            onValueChange = { viewModel.onLoginChanged(it) },
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
        Spacer(modifier = Modifier.height(35.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.email,
            isError = !state.isEmailValid,
            placeHolderText = stringResource(R.string.email),
            onValueChange = { viewModel.onEmailNameChanged(it) },
        )
        Spacer(modifier = Modifier.height(35.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .padding(horizontal = 44.dp),
            onClick = {
                if (viewModel.isValidFields(context)) {
                    scope.launch {
                        val user = viewModel.registerNewUser(
                            context = context,
                            user = User(
                                login = state.login,
                                password = state.password,
                                email = state.email
                            )
                        )
                        if (user != null)
                            navController.navigate(route = AuthorizationScreen.LoginScreen.route)
                    }
                }
            },
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = stringResource(R.string.sign_up))
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(start = 44.dp)
        ) {
            Text(text = stringResource(R.string.already_have_an_account))
            Text(
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable {
                        navController
                            .navigate(
                                route = AuthorizationScreen.LoginScreen.route
                            )
                    },
                text = stringResource(R.string.log_in),
                color = LogInColor
            )
        }
        Spacer(modifier = Modifier.height(70.dp))
        CustomButtonWithIcon(
            painter = painterResource(id = R.drawable.ic_google),
            text = stringResource(R.string.sign_up_with_google),
            onButtonClick = {
                val message = context.resources.getString(R.string.sign_up_with_google)
                viewModel.makeToast(context, message)
            }
        )
        Spacer(modifier = Modifier.height(34.dp))
        CustomButtonWithIcon(
            painter = painterResource(id = R.drawable.ic_apple),
            text = stringResource(R.string.sign_up_with_apple),
            onButtonClick = {
                val message = context.resources.getString(R.string.sign_up_with_apple)
                viewModel.makeToast(context, message)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    val context = LocalContext.current
    SignUpScreen(navController = NavController(context))
}