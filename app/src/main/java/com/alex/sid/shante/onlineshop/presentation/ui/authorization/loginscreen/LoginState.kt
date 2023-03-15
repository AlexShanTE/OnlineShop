package com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen

data class LoginState(
    val firstName: String = "",
    val password : String = "",
    val isPasswordShowed: Boolean = false,
    val isFirstNameValid: Boolean = true,
    val isPasswordValid: Boolean = true,
)