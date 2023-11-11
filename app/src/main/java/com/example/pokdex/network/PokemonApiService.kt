package com.example.pokdex.network

import com.example.pokdex.network.model.Pokemon
import com.example.pokdex.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemon(@Path("pokemonName") pokemonName: String): Pokemon

    @GET("pokemon")
    suspend fun getPokemonPaginatedResourcesList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ) : PokemonListResponse
}