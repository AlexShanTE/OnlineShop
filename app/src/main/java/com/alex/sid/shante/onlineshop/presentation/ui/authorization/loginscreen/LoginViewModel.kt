package com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.utils.FieldValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val fieldValidator = FieldValidator()

    fun onFirstNameChanged(firstName: String) {
        _state.update { state ->
            state.copy(firstName = firstName)
        }
    }

    fun onPasswordChanged(password: String) {
        _state.update { state ->
            state.copy(password = password)
        }
    }

    fun changePasswordVisibility() {
        _state.update { state ->
            state.copy(isPasswordShowed = !state.isPasswordShowed)
        }
    }

    fun isValidFields(context: Context): Boolean {
        val firstNameValid = fieldValidator.isFirstNameValid(state.value.firstName)
        val passwordIsValid = fieldValidator.isPasswordValid(state.value.password)
        _state.update { state ->
            state.copy(isFirstNameValid = firstNameValid, isPasswordValid = passwordIsValid)
        }
        if (!firstNameValid) {
            makeToast(context, context.getString(R.string.invalid_first_name))
            return false
        }
        if (!passwordIsValid) {
            makeToast(context, context.getString(R.string.invalid_password))
            return false
        }
        return true
    }

    private fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}