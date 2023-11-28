package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName(value = "base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: StatX
)