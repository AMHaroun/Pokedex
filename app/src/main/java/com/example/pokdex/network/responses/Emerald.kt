package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emerald(
    @SerialName(value = "front_default")
    val frontDefault: String?,
    @SerialName(value = "front_shiny")
    val frontShiny: String?
)