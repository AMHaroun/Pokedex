package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationVii(
    val icons: Icons,
    @SerialName(value = "ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)