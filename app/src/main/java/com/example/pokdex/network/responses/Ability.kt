package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val ability: AbilityX,
    @SerialName(value = "is_hidden")
    val isHidden: Boolean,
    val slot: Int
)