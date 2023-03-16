package com.alex.sid.shante.onlineshop.presentation.ui.authorization.signupscreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.sid.shante.onlineshop.R
import com.alex.sid.shante.onlineshop.di.IoDispatcher
import com.alex.sid.shante.onlineshop.domain.models.User
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
class SignUpViewModel @Inject constructor(
    private val repository: LoginRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.asStateFlow()

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

    fun onEmailNameChanged(email: String) {
        _state.update { state ->
            state.copy(email = email)
        }
    }

    fun changePasswordVisibility() {
        _state.update { state ->
            state.copy(isPasswordShowed = !state.isPasswordShowed)
        }
    }

    fun isValidFields(context: Context): Boolean {
        val loginValid = fieldValidator.isLastNameValid(state.value.login)
        val passwordValid = fieldValidator.isLastNameValid(state.value.password)
        val emailValid = fieldValidator.isEmailValid(state.value.email)
        _state.update { state ->
            state.copy(
                isLoginValid = loginValid,
                isPasswordValid = passwordValid,
                isEmailValid = emailValid
            )
        }
        if (!loginValid) {
            makeToast(context, context.getString(R.string.invalid_login))
            return false
        }
        if (!passwordValid) {
            makeToast(context, context.getString(R.string.invalid_password))
            return false
        }
        if (!emailValid) {
            makeToast(context, context.getString(R.string.invalid_email))
            return false
        }
        return true
    }

    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    suspend fun registerNewUser(context: Context, user: User) : User? {
        val login = user.login
        var currentUser: User? = null
        val job = viewModelScope.launch(dispatcher) {
            val foundUser = repository.getUser(login = login)
            if (foundUser?.login == user.login) {
                withContext(Dispatchers.Main) {
                    makeToast(
                        context,
                        context.getString(R.string.user_already_exist)
                    )
                }
                currentUser = null
            } else {
                withContext(dispatcher) {
                    try {
                        repository.insertUser(user)
                        currentUser = user
                    } catch (exception: Throwable) {
                        withContext(Dispatchers.Main) {
                            makeToast(
                                context,
                                context.getString(R.string.something_went_wrong)
                            )
                        }
                    }
                }

            }
        }
        job.join()
        return currentUser
    }
}
