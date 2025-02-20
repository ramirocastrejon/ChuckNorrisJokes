package com.ramiro.chucknorriscompose.domain

import com.ramiro.chucknorriscompose.data.model.JokeDomain

sealed class UiStates {
    object LOADING: UiStates()

    data class SUCCESS(val response: JokeDomain): UiStates()

    data class ERROR(val error:Exception): UiStates()
}