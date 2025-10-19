package com.example.viewproject.domain.repository


import com.example.viewproject.domain.model.User
import com.example.viewproject.util.Resource

interface IUserRepository {
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun register(fullName: String, email: String, password: String): Resource<User>
}
