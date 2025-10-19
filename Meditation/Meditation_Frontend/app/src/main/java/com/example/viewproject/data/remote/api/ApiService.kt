package com.example.viewproject.data.remote.api

import com.example.viewproject.data.remote.dto.*
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("api/accounts/login/")
    suspend fun login(@Body request: LoginRequest): UserResponse

    @POST("api/accounts/register/")
    suspend fun register(@Body request: RegisterRequest): UserResponse
}
