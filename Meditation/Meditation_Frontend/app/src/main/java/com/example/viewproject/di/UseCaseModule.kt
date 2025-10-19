package com.example.viewproject.di

import com.example.viewproject.domain.repository.IUserRepository
import com.example.viewproject.domain.usecase.auth.LoginUseCase
import com.example.viewproject.domain.usecase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(repo: IUserRepository): LoginUseCase = LoginUseCase(repo)

    @Provides
    @Singleton
    fun provideRegisterUseCase(repo: IUserRepository): RegisterUseCase = RegisterUseCase(repo)
}
