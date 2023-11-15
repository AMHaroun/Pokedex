package com.example.pokdex.data

import com.example.pokdex.Constants
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.PokemonApiService
import com.example.pokdex.network.responses.PokemonList
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class PokemonRemoteDataSource {

    private val baseUrl = Constants.baseUrl

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

    suspend fun getPokemonResourcesList(limit: Int, offset: Int): PokemonList =
        retrofitService.getPokemonPaginatedResourcesList(limit, offset)


}