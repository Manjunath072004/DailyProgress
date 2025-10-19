
package com.example.viewproject.ui.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewproject.domain.usecase.auth.LoginUseCase
import com.example.viewproject.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

private const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newEmail: String) {
        uiState = uiState.copy(email = newEmail)
    }

    fun onPasswordChange(newPass: String) {
        uiState = uiState.copy(password = newPass)
    }

    fun login() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            // Trim email and password to avoid 400 errors
            val emailTrimmed = uiState.email.trim()
            val passwordTrimmed = uiState.password.trim()

            Log.d(TAG, "Attempting login with: email='$emailTrimmed'")

            when (val result = loginUseCase(emailTrimmed, passwordTrimmed)) {
                is Resource.Success -> {
                    Log.d(TAG, "Login successful: ${result.data}")
                    uiState = uiState.copy(isLoggedIn = true, isLoading = false)
                }
                is Resource.Error -> {
                    Log.e(TAG, "Login failed: ${result.message}")
                    uiState = uiState.copy(error = result.message ?: "Login failed", isLoading = false)
                }
            }
        }
    }
}
