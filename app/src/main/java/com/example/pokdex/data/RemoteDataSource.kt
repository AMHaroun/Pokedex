package com.example.pokdex.data

import com.example.pokdex.network.PokemonEntity
import com.example.pokdex.network.PokemonApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface PokedexDataSource{
    suspend fun getPokemonData(pokemonName: String) : Flow<PokemonEntity>

}

class RemoteDataSource: PokedexDataSource {

    private val baseUrl = "https://pokeapi.co/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService by lazy{
        retrofit.create(PokemonApiService::class.java)
    }

    override suspend fun getPokemonData(pokemonName: String): Flow<PokemonEntity> =
        retrofitService.getPokemonData(pokemonName)


}