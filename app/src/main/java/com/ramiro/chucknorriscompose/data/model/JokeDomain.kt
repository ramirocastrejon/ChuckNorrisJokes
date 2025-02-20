package com.ramiro.chucknorriscompose.data.model

data class JokeDomain(
    val iconUrl: String? = "",
    val url: String? = "",
    val value: String? = ""
)

fun Jokemodel.toDomain(): JokeDomain{
    return JokeDomain(
        iconUrl = iconUrl,
        url = url,
        value = value
    )
}
