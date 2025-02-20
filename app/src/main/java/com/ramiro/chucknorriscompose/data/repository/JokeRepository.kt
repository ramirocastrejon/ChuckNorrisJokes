package com.ramiro.chucknorriscompose.data.repository

import com.ramiro.chucknorriscompose.data.model.Jokemodel
import retrofit2.Response

interface JokeRepository {

    suspend fun getRandomJoke(): Response<Jokemodel>
}