package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokdex.data.PokemonRemoteDataSource
import com.example.pokdex.data.PokemonRepository

class PokemonListScreenViewModelFactory(
    private val repository: PokemonRepository = PokemonRepository(PokemonRemoteDataSource())
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PokemonListScreenViewModel::class.java)) {
            return PokemonListScreenViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}