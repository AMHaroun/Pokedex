package com.example.pokdex.data

import com.example.pokdex.util.Resource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PokemonRepositoryImplTest{

    private lateinit var pokemonRepository : PokemonRepositoryImpl
    private lateinit var fakePokemonApiService: FakePokemonApiService

    @Before
    fun setUp(){
        fakePokemonApiService = FakePokemonApiService()
        pokemonRepository = PokemonRepositoryImpl(dataSource = fakePokemonApiService)
    }

    @Test
    fun getPokemon_validPokemonName_returnsSuccess(): Unit = runBlocking{

        val pokemonName = "ditto"
        val result = pokemonRepository.getPokemon(pokemonName)

        assertThat(result is Resource.Success)
    }

    @Test
    fun getPokemon_networkError_returnsError(): Unit = runBlocking{

        // The string "Throw Exception" will cause the fakePokemonApiService
        // to simulate a network error
        val networkError = "ThrowException"

        val result = pokemonRepository.getPokemon(networkError)

        assertThat(result is Resource.Error)
    }

    @Test
    fun getPokemonList_validRequest_returnsSuccess(): Unit = runBlocking{
        val limit = 20
        val offset = 0

        val result = pokemonRepository.getPokemonList(limit, offset)

        assertThat(result is Resource.Success)
    }

    @Test
    fun getPokemonList_networkError_returnsError(): Unit = runBlocking{

        // passing a limit & offset of zero will cause fakePokemonApiService to simulate
        // a network error
        val limit = 0
        val offset = 0

        val result = pokemonRepository.getPokemonList(limit, offset)

        assertThat(result is Resource.Error)
    }

    @Test
    fun getPokemonStatId_validRequest_returnsSuccess(): Unit = runBlocking{
        val id = 132

        val result = pokemonRepository.getPokemonStat(id)

        assertThat(result is Resource.Success)
    }

    @Test
    fun getPokemonStatId_networkError_returnsError(): Unit = runBlocking{

        // passing a id of zero will cause fakePokemonApiService to simulate
        // a network error
        val id = 0

        val result = pokemonRepository.getPokemonStat(id)

        assertThat(result is Resource.Error)
    }

    @Test
    fun getPokemonStatName_validRequest_returnsSuccess(): Unit = runBlocking{
        val pokemonName = "ditto"

        val result = pokemonRepository.getPokemonStat(pokemonName)

        assertThat(result is Resource.Success)
    }

    @Test
    fun getPokemonStatName_networkError_returnsError(): Unit = runBlocking{

        // Passing the string "ThrowException" will cause fakePokemonApiService to simulate
        // a network error
        val pokemonName = "ThrowException"

        val result = pokemonRepository.getPokemonStat(pokemonName)

        assertThat(result is Resource.Error)
    }

}