package com.example.pokdex.data

import com.example.pokdex.network.model.Pokemon
import com.example.pokdex.network.model.PokemonListResponse


class PokemonRepository(
    private val dataSource: PokemonRemoteDataSource
){

    suspend fun getIndividualPokemonData(pokemonName: String): Pokemon =
        dataSource.getPokemon(pokemonName)

    suspend fun getListOfPokemon(limit: Int, offset: Int): PokemonListResponse =
        dataSource.getPokemonResourcesList(limit, offset)

}