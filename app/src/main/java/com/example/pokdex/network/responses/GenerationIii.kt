package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationIii(
    val emerald: Emerald,
    @SerialName(value = "firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen,
    @SerialName(value = "ruby-sapphire")
    val rubySapphire: RubySapphire
)