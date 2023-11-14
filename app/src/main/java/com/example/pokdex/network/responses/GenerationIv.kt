package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationIv(
    @SerialName(value = "diamond-pearl")
    val diamondPearl: DiamondPearl,
    @SerialName(value = "heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)