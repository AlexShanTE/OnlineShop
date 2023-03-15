package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signinscreen

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
class SignInViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState> = _state.asStateFlow()

    private val fieldValidator = FieldValidator()

    fun onFirstNameChanged(firstName: String) {
        _state.update { state ->
            state.copy(firstName = firstName)
        }
    }

    fun onLastNameChanged(lastName: String) {
        _state.update { state ->
            state.copy(lastName = lastName)
        }
    }

    fun onEmailNameChanged(email: String) {
        _state.update { state ->
            state.copy(email = email)
        }
    }

    fun isValidFields(context: Context): Boolean {
        val firstNameValid = fieldValidator.isFirstNameValid(state.value.firstName)
        val lastNameValid = fieldValidator.isLastNameValid(state.value.lastName)
        val emailValid = fieldValidator.isEmailValid(state.value.email)
        _state.update { state ->
            state.copy(
                isFirstNameValid = firstNameValid,
                isLastNameValid = lastNameValid,
                isEmailValid = emailValid
            )
        }
        if (!firstNameValid) {
            makeToast(context, context.getString(R.string.invalid_first_name))
            return false
        }
        if (!lastNameValid) {
            makeToast(context, context.getString(R.string.invalid_last_name))
            return false
        }
        if (!emailValid) {
            makeToast(context, context.getString(R.string.invalid_email))
            return false
        }
        return true
    }

    private fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}