package com.example.pokdex.network.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val abilities: List<Ability>,
    @SerialName(value = "base_experience")
    val baseExperience: Int,
    val forms: List<Form>,
    @SerialName(value = "game_indices")
    val gameIndices: List<GameIndice>,
    val height: Int,
    @SerialName(value = "held_items")
    val heldItems: List<HeldItem>,
    val id: Int,
    @SerialName(value = "is_default")
    val isDefault: Boolean,
    @SerialName(value = "location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerialName(value = "past_abilities")
    val pastAbilities: List<Ability>,
    @SerialName(value = "past_types")
    val pastTypes: List<Type>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)