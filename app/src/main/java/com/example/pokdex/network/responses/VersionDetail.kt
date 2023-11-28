package com.example.pokdex.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class VersionDetail(
    val rarity: Int,
    val version: Version
)