package com.ramiro.chucknorriscompose.di

import com.ramiro.chucknorriscompose.data.repository.JokeRepository
import com.ramiro.chucknorriscompose.data.repository.JokeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesRepository(
        repositoryImpl: JokeRepositoryImpl
    ): JokeRepository
}