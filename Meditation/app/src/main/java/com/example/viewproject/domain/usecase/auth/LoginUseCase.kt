package com.example.viewproject.domain.usecase.auth

import com.example.viewproject.domain.repository.IUserRepository

// domain/usecase/auth/LoginUseCase.kt
class LoginUseCase(private val repo: IUserRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repo.login(email, password)
}