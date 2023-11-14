package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationV(
    @SerialName(value = "black-white")
    val blackWhite: BlackWhite
)