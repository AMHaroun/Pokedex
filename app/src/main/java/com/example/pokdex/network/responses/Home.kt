package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Home(
    @SerialName(value = "front_default")
    val frontDefault: String?,
    @SerialName(value = "front_female")
    val frontFemale: String?,
    @SerialName(value = "front_shiny")
    val frontShiny: String?,
    @SerialName(value = "front_shiny_female")
    val frontShinyFemale: String?
)