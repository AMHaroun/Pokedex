package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokdex.data.PokemonRemoteDataSource
import com.example.pokdex.data.PokemonRepository

class PokemonListScreenViewModelFactory(
    private val repository: PokemonRepository = PokemonRepository(PokemonRemoteDataSource())
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Checks if class passed is the same as our viewmodel
        if(modelClass.isAssignableFrom(PokemonListScreenViewModel::class.java)) {
            // returns a made viewmodel with our dependency
            return PokemonListScreenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}