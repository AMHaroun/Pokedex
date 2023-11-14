package com.example.pokdex.data

import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.responses.PokemonList


class PokemonRepository(
    private val dataSource: PokemonRemoteDataSource
){

    suspend fun getPokemon(pokemonName: String): Pokemon =
        dataSource.getPokemon(pokemonName)

    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList =
        dataSource.getPokemonResourcesList(limit, offset)

}