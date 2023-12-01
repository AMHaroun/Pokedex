package com.example.pokdex.network.responses

data class AffectingMoves(
    val decrease: List<Any>,
    val increase: List<Any>
)