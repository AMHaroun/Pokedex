package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.PokemonListEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


sealed class PokedexUiState{

    data class Success(val pokemonList: MutableList<PokemonListEntry>) : PokedexUiState()
    object Loading: PokedexUiState()
    object Error: PokedexUiState()

}
class PokemonListScreenViewModel(
    private val repository: PokemonRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<PokedexUiState> = MutableStateFlow(PokedexUiState.Loading)
    val uiState = _uiState.asStateFlow()



}