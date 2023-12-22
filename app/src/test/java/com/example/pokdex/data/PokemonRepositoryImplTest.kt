package com.example.pokdex.data

import org.junit.Before

class PokemonRepositoryImplTest{

    private lateinit var pokemonRepository : PokemonRepositoryImpl
    private lateinit var fakePokemonApiService: FakePokemonApiService

    @Before
    fun setUp(){
        fakePokemonApiService = FakePokemonApiService()
        pokemonRepository = PokemonRepositoryImpl(dataSource = fakePokemonApiService)
    }
}