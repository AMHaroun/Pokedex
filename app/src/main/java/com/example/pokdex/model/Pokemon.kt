package com.example.pokdex.model

import com.example.pokdex.network.responses.Stat
import com.example.pokdex.network.responses.Type

data class Pokemon(
    val height: Int,
    val id: Int,
    val name: String,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
    val imageUrl: String
)
