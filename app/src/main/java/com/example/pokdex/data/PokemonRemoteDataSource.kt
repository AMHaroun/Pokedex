package com.example.pokdex.data

import com.example.pokdex.network.model.Pokemon
import com.example.pokdex.network.model.PokemonListResponse
import com.example.pokdex.network.PokemonApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class PokemonRemoteDataSource {

    private val baseUrl = "https://pokeapi.co/api/v2/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json{ignoreUnknownKeys = true}
            .asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService by lazy{
        retrofit.create(PokemonApiService::class.java)
    }

    suspend fun getPokemon(pokemonName: String): Pokemon =
        retrofitService.getPokemon(pokemonName)

    suspend fun getPokemonResourcesList(limit: Int, offset: Int): PokemonListResponse =
        retrofitService.getPokemonPaginatedResourcesList(limit, offset)


}