package com.ramiro.chucknorriscompose.domain

import com.ramiro.chucknorriscompose.data.model.toDomain
import com.ramiro.chucknorriscompose.data.repository.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetRandomJokeUseCase @Inject constructor(
    private val jokeRepository: JokeRepository
) {
    fun getRandomJoke(): Flow<UiStates> = flow {
        emit(UiStates.LOADING)
        try {
            val response = jokeRepository.getRandomJoke()
            if (response.isSuccessful){
                response.body()?.let {
                    emit(UiStates.SUCCESS(it.toDomain()))
                }?: throw Exception("List is empty!")
            }else throw Exception(response.errorBody()?.toString())
        }catch (e: Exception){
            emit(UiStates.ERROR(e))
        }

    }
}