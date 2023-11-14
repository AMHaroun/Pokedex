package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationI(
    @SerialName(value = "red-blue")
    val redBlue: RedBlue,
    val yellow: Yellow
)