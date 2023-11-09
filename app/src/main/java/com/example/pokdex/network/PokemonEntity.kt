package com.example.pokdex.network

import kotlinx.serialization.Serializable

@Serializable
data class PokemonEntity(
    val name: String,
    val id: Int,
    val order: Int,
    val weight: Int,
)
