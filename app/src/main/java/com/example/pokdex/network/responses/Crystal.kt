package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Crystal(
    @SerialName(value = "back_default")
    val backDefault: String?,
    @SerialName(value = "back_shiny")
    val backShiny: String?,
    @SerialName(value = "back_shiny_transparent")
    val backShinyTransparent: String?,
    @SerialName(value = "back_transparent")
    val backTransparent: String?,
    @SerialName(value = "front_default")
    val frontDefault: String?,
    @SerialName(value = "front_shiny")
    val frontShiny: String?,
    @SerialName(value = "front_shiny_transparent")
    val frontShinyTransparent: String?,
    @SerialName(value = "front_transparent")
    val frontTransparent: String?
)