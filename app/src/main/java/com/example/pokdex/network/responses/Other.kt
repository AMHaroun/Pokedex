package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName

data class Other(
    @SerialName("dream_world")
    val dream_world: DreamWorld,
    val home: Home,
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtwork
)