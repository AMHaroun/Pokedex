package com.example.pokdex.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {

    @GET("api/v2/{pokemonName}")
    suspend fun getPokemonData(@Path("pokemonName") pokemonName: String): Flow<PokemonEntity>
}