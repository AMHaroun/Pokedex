package com.example.pokdex.data

import com.example.pokdex.util.Resource
import com.example.pokdex.network.PokemonApiService
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.network.responses.PokemonList
import com.example.pokdex.network.responses.PokemonStat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val dataSource: PokemonApiService
): PokemonRepository{

    override suspend fun getPokemon(pokemonName: String): Resource<Pokemon> {

        val result  = try{
            withContext(Dispatchers.IO) {
                dataSource.getPokemon(pokemonName)
            }
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {

        val result = try {
            withContext(Dispatchers.IO){
                dataSource.getPokemonPaginatedResourcesList(limit, offset)
            }
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)

    }

    override suspend fun getPokemonStat(id: Int): Resource<PokemonStat> {

        val result = try {
            withContext(Dispatchers.IO) {
                dataSource.getPokemonStatById(id)
            }
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)
    }
    override suspend fun getPokemonStat(pokemonName: String): Resource<PokemonStat> {

        val result = try {
            withContext(Dispatchers.IO) {
                dataSource.getPokemonStatByName(pokemonName)
            }
        } catch (e: Exception){
            return Resource.Error("Failed to fetch data", null)
        }
        return Resource.Success(result)
    }



}