package com.example.pokdex.data

import com.example.pokdex.util.Resource
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.responses.PokemonList
import com.example.pokdex.network.responses.PokemonStat

interface PokemonRepository{
    suspend fun  getPokemon(pokemonName: String): Resource<Pokemon>

    /*
     *  limit: Int -> refers to how many pokemon are loaded into the list
     *  offset: Int -> refers to what index to start loading pokemon into the list from
     */
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>

    suspend fun getPokemonStat(id: Int): Resource<PokemonStat>

    suspend fun getPokemonStat(pokemonName: String): Resource<PokemonStat>
}