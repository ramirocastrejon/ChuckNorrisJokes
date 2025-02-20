package com.ramiro.chucknorriscompose.data.api

import com.ramiro.chucknorriscompose.data.model.Jokemodel
import retrofit2.Response
import retrofit2.http.GET

interface ServiceCall {
    //https://api.chucknorris.io/jokes/random
    @GET(RANDOM_ENDPOINT)
    suspend fun getRandomJoke(): Response<Jokemodel>

}