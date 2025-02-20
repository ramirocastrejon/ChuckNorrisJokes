package com.ramiro.chucknorriscompose.data.model


import com.google.gson.annotations.SerializedName

data class Jokemodel(
    @SerializedName("categories")
    val categories: List<Any?>? = listOf(),
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("icon_url")
    val iconUrl: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("value")
    val value: String? = ""
)