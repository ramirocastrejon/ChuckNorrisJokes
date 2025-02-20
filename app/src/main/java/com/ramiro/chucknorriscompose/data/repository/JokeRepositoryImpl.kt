package com.ramiro.chucknorriscompose.data.repository

import com.ramiro.chucknorriscompose.data.api.ServiceCall
import com.ramiro.chucknorriscompose.data.model.Jokemodel
import retrofit2.Response
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val serviceCall: ServiceCall
) : JokeRepository {
    override suspend fun getRandomJoke(): Response<Jokemodel> {
        return serviceCall.getRandomJoke()
    }

}