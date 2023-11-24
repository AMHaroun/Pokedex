package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokdex.PokedexApplication
import com.example.pokdex.data.PokemonRepository

class PokemonDetailScreenViewModel(repository: PokemonRepository): ViewModel(){

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val pokedexRepository = application.container.pokemonRepository
                PokemonDetailScreenViewModel(repository = pokedexRepository)
            }
        }
    }
}