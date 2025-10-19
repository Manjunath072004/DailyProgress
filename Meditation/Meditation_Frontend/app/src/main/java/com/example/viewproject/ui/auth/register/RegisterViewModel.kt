package com.example.viewproject.ui.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewproject.domain.usecase.auth.RegisterUseCase
import com.example.viewproject.util.Resource

import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.room.util.copy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onFullNameChange(value: String) {
        uiState = uiState.copy(fullName = value)
    }

    fun onEmailChange(value: String) {
        uiState = uiState.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value)
    }

    fun register() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            when (val result = registerUseCase(uiState.fullName, uiState.email, uiState.password)) {
                is Resource.Success -> {
                    uiState = uiState.copy(isRegistered = true, isLoading = false)
                }
                is Resource.Error -> {
                    uiState = uiState.copy(error = result.message, isLoading = false)
                }
            }
        }
    }
}
