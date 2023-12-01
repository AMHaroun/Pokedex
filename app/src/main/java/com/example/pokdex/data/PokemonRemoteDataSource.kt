package com.example.pokdex.data

import com.example.pokdex.Constants
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.PokemonApiService
import com.example.pokdex.network.responses.PokemonList
import com.example.pokdex.network.responses.PokemonStat
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class PokemonRemoteDataSource {

    private val baseUrl = Constants.BASE_URL

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

    suspend fun getPokemonPaginatedResourcesList(limit: Int, offset: Int): PokemonList =
        retrofitService.getPokemonPaginatedResourcesList(limit, offset)

    suspend fun getPokemonStatById(id: Int): PokemonStat =
        retrofitService.getPokemonStatById(id)

    suspend fun getPokemonStatByString(pokemonName: String): PokemonStat =
        retrofitService.getPokemonStatByName(pokemonName)

}