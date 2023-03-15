package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signinscreen

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
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.theme.LogInColor
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.signinscreen.components.CustomButtonWithIcon
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.common.CustomTextField

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val viewModel: SignInViewModel = hiltViewModel()
        val state by viewModel.state.collectAsState()
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.sign_in),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(60.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.firstName,
            isError = !state.isFirstNameValid,
            placeHolderText = stringResource(R.string.first_name),
            onValueChange = { viewModel.onFirstNameChanged(it) },
        )
        Spacer(modifier = Modifier.height(35.dp))
        CustomTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            value = state.lastName,
            isError = !state.isLastNameValid,
            placeHolderText = stringResource(R.string.last_name),
            onValueChange = { viewModel.onLastNameChanged(it) },
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
                //todo navigate
                viewModel.isValidFields(context)
            },
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = stringResource(R.string.sign_in))
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
                        /*TODO*/
                    },
                text = stringResource(R.string.log_in),
                color = LogInColor
            )
        }
        Spacer(modifier = Modifier.height(70.dp))
        CustomButtonWithIcon(
            painter = painterResource(id = R.drawable.ic_google),
            text = "Sign with Google",
            onButtonClick = { }
        )
        Spacer(modifier = Modifier.height(38.dp))
        CustomButtonWithIcon(
            painter = painterResource(id = R.drawable.ic_apple),
            text = "Sign with Apple",
            onButtonClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}