package com.example.pokdex.ui.screens

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.network.model.PokemonListResponse
import com.example.pokdex.network.model.PokemonReference
import com.example.pokdex.ui.model.PokemonUiReference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// TODO: create ui state that represents data you will show in PokemonListScreen()
// TODO: create functions for saving and un-saving pokemon from database

sealed class PokedexUiState{

    data class Success(val pokemonList: MutableList<PokemonReference>) : PokedexUiState()
    object Loading: PokedexUiState()
    object Error: PokedexUiState()

}
class PokemonListScreenViewModel(
    private val repository: PokemonRepository
): ViewModel() {
    private var offset: Int = 0

    private val _uiState: MutableStateFlow<PokedexUiState.Success> = MutableStateFlow(
        PokedexUiState.Success(mutableListOf())
    )
    val uiState = _uiState.asStateFlow()

    init {
        fetchPokemonReferences()
    }
    fun fetchPokemonReferences(){
        viewModelScope.launch {
            val response = repository.getListOfPokemon(20, offset)
            offset += 20
            _uiState.value.pokemonList.addAll(response.results)
        }
    }


}