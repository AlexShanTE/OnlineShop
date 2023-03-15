package com.alex.sid.shante.onlineshop.presentation.ui.authorization.utils

import android.util.Patterns

class FieldValidator {

    fun isFirstNameValid(firstName: String): Boolean {
        return firstName.isNotEmpty()
    }

    fun isLastNameValid(lastName: String): Boolean {
        return lastName.isNotEmpty()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}