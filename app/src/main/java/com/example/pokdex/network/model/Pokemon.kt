package com.example.pokdex.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//Models Json Data returned from https://pokeapi.co/api/v2/pokemon/{id or name} ex."ditto"/
@Serializable
data class Pokemon(

    @SerialName(value = "id")
    val id: Int = 0,

    @SerialName(value = "name")
    val name: String,

    @SerialName(value = "base_experience")
    val baseExperience: Int = 0,

    @SerialName(value = "height")
    val height: Int = 0,

    @SerialName(value = "is_default")
    val isDefault: Boolean = true,

    @SerialName(value = "order")
    val order: Int = 0,

    @SerialName(value = "weight")
    val weight: Int = 0,

    @SerialName(value = "abilities")
    val abilities: List<AbilityInfo> = emptyList(),

    @SerialName(value = "forms")
    val forms: List<Form> = emptyList(),

    )


@Serializable
data class AbilityInfo(
    @SerialName(value = "is_hidden")
    val isHidden: Boolean,
    @SerialName(value = "slot")
    val slot: Int,
    @SerialName(value = "ability")
    val ability: Ability
)
@Serializable
data class Ability(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "url")
    val url: String
)

@Serializable
data class Form(
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "url")
    val url: String
)
