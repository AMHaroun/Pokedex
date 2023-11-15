package com.example.pokdex

object Constants {

    /* Base url of the remote service used to get pokemon data */
    const val BASE_URL: String = "https://pokeapi.co/api/v2/"

    /* The number of how many results we request from the remote server per
     * request to "https://pokeapi.co/api/v2/pokemon" */
    const val PAGE_SIZE: Int = 20
}