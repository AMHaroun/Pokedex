package com.example.pokdex.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val name: String,
    val url: String
)