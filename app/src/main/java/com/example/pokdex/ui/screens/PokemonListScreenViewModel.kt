package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokdex.data.PokedexRepository
import com.example.pokdex.network.PokemonEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

// TODO: create ui state that represents data you will show in PokemonListScreen()
// TODO: create functions for saving and un-saving pokemon from database

class PokemonListScreenViewModel(private val repository: PokedexRepository): ViewModel() {

}