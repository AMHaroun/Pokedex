package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVii(
    val icons: Icons,
    @SerialName(value = "ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)