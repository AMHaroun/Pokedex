package com.example.pokdex.network

import com.example.pokdex.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {

    @GET("api/v2/{pokemonName}")
    suspend fun getPokemon(@Path("pokemonName") pokemonName: String): Pokemon
}