package com.example.pokdex.data

import com.example.pokdex.network.PokemonEntity
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    suspend fun getPokemonData(pokemonName: String): Flow<PokemonEntity>

}

class NetworkPokedexRepository(private val dataSource: PokedexDataSource) : PokedexRepository {

    override suspend fun getPokemonData(pokemonName: String): Flow<PokemonEntity> =
        dataSource.getPokemonData(pokemonName)
}