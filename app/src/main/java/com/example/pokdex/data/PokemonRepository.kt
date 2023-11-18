package com.example.pokdex.data

import com.example.pokdex.Resource
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.responses.PokemonList


class PokemonRepository(
    private val dataSource: PokemonRemoteDataSource
){

    suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {

        val result  = try{
            dataSource.getPokemon(pokemonName)
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)
    }

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {

        val result = try {
            dataSource.getPokemonResourcesList(limit, offset)
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)

    }

}