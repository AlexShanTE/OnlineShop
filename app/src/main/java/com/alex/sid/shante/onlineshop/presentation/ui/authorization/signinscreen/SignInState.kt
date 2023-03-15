package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signinscreen

data class SignInState(
    val firstName: String = "",
    val lastName:String = "",
    val email: String = "",
    val isFirstNameValid: Boolean = true,
    val isLastNameValid: Boolean = true,
    val isEmailValid: Boolean = true,
)
