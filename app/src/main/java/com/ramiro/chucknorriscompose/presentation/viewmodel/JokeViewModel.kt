package com.ramiro.chucknorriscompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramiro.chucknorriscompose.domain.GetRandomJokeUseCase
import com.ramiro.chucknorriscompose.domain.UiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val getRandomJokeUseCase: GetRandomJokeUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel(){

    private val _jokeState: MutableStateFlow<UiStates> = MutableStateFlow(UiStates.LOADING)
    val jokeState: StateFlow<UiStates> get()  = _jokeState

    fun getRandomJoke(){
        viewModelScope.launch(dispatcher) {
            getRandomJokeUseCase.getRandomJoke().collect{
                _jokeState.value = it
            }
        }
    }

}