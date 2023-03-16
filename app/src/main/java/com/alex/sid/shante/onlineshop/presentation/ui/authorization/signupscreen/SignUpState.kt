package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen

data class SignUpState(
    val login: String = "",
    val password: String = "",
    val email: String = "",
    val isPasswordShowed: Boolean = false,
    val isLoginValid: Boolean = true,
    val isPasswordValid: Boolean = true,
    val isEmailValid: Boolean = true
)
