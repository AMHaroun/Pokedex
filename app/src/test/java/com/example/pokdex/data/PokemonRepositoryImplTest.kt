package com.example.pokdex.data

import com.example.pokdex.Resource
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
}