package com.example.pokdex.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Models paginated response from https://pokeapi.co/api/v2/pokemon
@Serializable
data class PokemonListResponse(
    @SerialName(value = "count")
    val count: Int,

    @SerialName(value = "next")
    val next: String,

    @SerialName(value = "previous")
    val previous: String?,

    @SerialName(value = "results")
    val results: List<PokemonReference>
)


@Serializable
data class PokemonReference(
    @SerialName(value = "name")
    val name: String,

    @SerialName(value = "url")
    val url: String
)