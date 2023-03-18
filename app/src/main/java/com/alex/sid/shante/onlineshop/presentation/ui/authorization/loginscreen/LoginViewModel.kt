package com.alex.sid.shante.onlineshop.presentation.ui.authorization.loginscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.di.IoDispatcher
import com.alex.sid.shante.onlineshop.domain.repositories.LoginRepository
import com.alex.sid.shante.onlineshop.presentation.ui.authorization.utils.FieldValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val fieldValidator = FieldValidator()

    fun onLoginChanged(login: String) {
        _state.update { state ->
            state.copy(login = login)
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
        val loginValid = fieldValidator.isFirstNameValid(state.value.login)
        val passwordIsValid = fieldValidator.isPasswordValid(state.value.password)
        _state.update { state ->
            state.copy(isLoginValid = loginValid, isPasswordValid = passwordIsValid)
        }
        if (!loginValid) {
            makeToast(context, context.getString(R.string.invalid_login))
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

    fun login(context: Context, login: String, password: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val user = repository.getUser(login = login)
                if (user?.password == password) {
                    _state.update { state -> state.copy(currentUser = user) }
                } else
                    withContext(Dispatchers.Main) {
                        makeToast(context, context.getString(R.string.user_not_found))
                    }
            } catch (exception: Throwable) {
                makeToast(context, context.getString(R.string.user_not_found))
            }
        }
    }

    fun resetState() {
        _state.update { state ->
            state.copy(
                login = "",
                password = "",
                currentUser = null,
                isPasswordShowed = false,
                isLoginValid = true,
                isPasswordValid = true,
            )
        }
    }
}