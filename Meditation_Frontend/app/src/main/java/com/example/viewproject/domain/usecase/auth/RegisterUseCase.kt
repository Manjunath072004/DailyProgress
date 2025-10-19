package com.example.viewproject.domain.usecase.auth

import com.example.viewproject.domain.repository.IUserRepository


// domain/usecase/auth/RegisterUseCase.kt
class RegisterUseCase(private val repo: IUserRepository) {
    suspend operator fun invoke(fullName: String, email: String, password: String) =
        repo.register(fullName, email, password)
}