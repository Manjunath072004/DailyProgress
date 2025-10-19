package com.example.viewproject.data.repository

import com.example.viewproject.data.remote.api.ApiService
import com.example.viewproject.data.remote.dto.LoginRequest
import com.example.viewproject.data.remote.dto.RegisterRequest
import com.example.viewproject.domain.model.User
import com.example.viewproject.domain.repository.IUserRepository
import com.example.viewproject.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val api: ApiService
) : IUserRepository {

    override suspend fun login(email: String, password: String): Resource<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.login(LoginRequest(email, password))
                Resource.Success(
                    User(
                        id = response.id,
                        fullName = response.full_name,
                        email = response.email,
                        username = response.username
                    )
                )
            } catch (e: Exception) {
                Resource.Error(e.message ?: "Login failed")
            }
        }

    override suspend fun register(fullName: String, email: String, password: String): Resource<User> =
        withContext(Dispatchers.IO) {
            try {
                val response = api.register(RegisterRequest(fullName, email, password))
                Resource.Success(
                    User(
                        id = response.id,
                        fullName = response.full_name,
                        email = response.email,
                        username = response.username
                    )
                )
            } catch (e: Exception) {
                Resource.Error(e.message ?: "Registration failed")
            }
        }
}
