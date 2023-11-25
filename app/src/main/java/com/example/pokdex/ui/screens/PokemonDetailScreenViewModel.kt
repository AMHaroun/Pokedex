package com.example.pokdex.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokdex.PokedexApplication
import com.example.pokdex.Resource
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.Pokemon
import kotlinx.coroutines.launch

sealed interface PokemonDetailScreenUiState{

    data class Success(val pokemon: Pokemon) : PokemonDetailScreenUiState
    data class Error(val errorMessage: String): PokemonDetailScreenUiState
    object Loading: PokemonDetailScreenUiState
}
class PokemonDetailScreenViewModel(val repository: PokemonRepository): ViewModel(){

    var uiState: PokemonDetailScreenUiState by mutableStateOf(PokemonDetailScreenUiState.Loading)
        private set

    fun getPokemonData(pokemonName: String){

        viewModelScope.launch {

            val result = repository.getPokemon(pokemonName)

            when(result){

                is Resource.Success ->{

                    val pokemon = Pokemon(
                        height = result.data.height,
                        id = result.data.id,
                        name = result.data.name,
                        stats = result.data.stats,
                        types = result.data.types,
                        weight = result.data.weight
                    )

                    uiState = PokemonDetailScreenUiState.Success(pokemon)

                }

                is Resource.Error ->{
                    uiState = PokemonDetailScreenUiState.Error(result.message)
                }

            }
        }

    }

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