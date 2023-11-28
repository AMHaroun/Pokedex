package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIv(
    @SerialName(value = "diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerialName(value = "heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)