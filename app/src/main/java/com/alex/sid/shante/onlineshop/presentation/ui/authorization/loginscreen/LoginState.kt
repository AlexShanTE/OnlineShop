package com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen

import com.alex.sid.shante.onlineshop.domain.models.User

data class LoginState(
    val login: String = "",
    val password : String = "",
    val user: User = User(),
    val isPasswordShowed: Boolean = false,
    val isLoginValid: Boolean = true,
    val isPasswordValid: Boolean = true,
)