package com.example.view.api;

import com.example.view.model.LoginRequest;
import com.example.view.model.LoginResponse;
import com.example.view.model.ProtectedResponse;
import com.example.view.model.SignupRequest;
import com.example.view.model.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("accounts/signup/")
    Call<SignupResponse> signup(@Body SignupRequest signupRequest);

    @POST("accounts/login/")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("protected/")
    Call<ProtectedResponse> getProtectedData();


}
