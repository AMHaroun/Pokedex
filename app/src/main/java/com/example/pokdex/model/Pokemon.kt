package com.example.pokdex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


//Models Json Data returned from https://pokeapi.co/api/v2/pokemon/{id or name ex."ditto"}/
@Serializable
data class Pokemon(

    @SerialName(value = "id")
    val id: Int,

    @SerialName(value = "name")
    val name: String,

    @SerialName(value = "base_experience")
    val baseExperience: Int,

    @SerialName(value = "height")
    val height: Int,

    @SerialName(value = "is_default")
    val isDefault: Boolean,

    @SerialName(value = "order")
    val order: Int,

    @SerialName(value = "weight")
    val weight: Int,

    @SerialName(value = "abilities")
    val abilities: List<AbilityInfo>,

    @SerialName(value = "forms")
    val forms: List<Form>,

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
