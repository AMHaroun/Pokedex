package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FireredLeafgreen(
    @SerialName(value = "back_default")
    val backDefault: String?,
    @SerialName(value = "back_shiny")
    val backShiny: String?,
    @SerialName(value = "front_default")
    val frontDefault: String?,
    @SerialName(value = "front_shiny")
    val frontShiny: String?
)