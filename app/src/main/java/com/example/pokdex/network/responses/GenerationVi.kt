package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class GenerationVi(
    @SerialName(value = "omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerialName(value = "x-y")
    val xY: XY
)