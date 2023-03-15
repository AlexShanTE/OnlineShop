package com.alex.sid.shante.onlineshop.presentation.ui.authorization.common

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alex.sid.shante.onlineshop.presentation.theme.Error
import com.alex.sid.shante.onlineshop.presentation.theme.HintColor

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    value: String,
    placeHolderText: String,
    isValueVisible: Boolean = true,
    isError: Boolean = false,
    trailingIcon: @Composable() (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val interactionSource = remember { MutableInteractionSource() }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .width(290.dp)
                .align(Alignment.Center)
                .padding(horizontal = 44.dp)
                .background(
                    color = Color(0xFFE8E8E8),
                    shape = RoundedCornerShape(15.dp)
                ),
            textStyle = MaterialTheme.typography.body1.copy(
                textAlign = TextAlign.Center,
                color = if (isError) Error else HintColor
            ),
            visualTransformation = if (isValueVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            ),
        ) {
            TextFieldDefaults.TextFieldDecorationBox(
                value = value,
                innerTextField = it,
                singleLine = true,
                enabled = true,
                isError = isError,
                visualTransformation = VisualTransformation.None,
                trailingIcon = trailingIcon,
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.body1.copy(
                            textAlign = TextAlign.Center,
                            color = if (isError) Error else HintColor
                        ),
                        text = placeHolderText,
                        color = if (isError) Error else HintColor
                    )
                },
                interactionSource = interactionSource,
                contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                    top = 2.dp, bottom = 2.dp
                )
            )
        }
    }
}