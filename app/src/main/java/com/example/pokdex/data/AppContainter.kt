package com.example.pokdex.data

/*
*   Dependency Injection Container
* */
class AppContainter {

    val pokemonRepository = PokemonRepository(PokemonRemoteDataSource())

}