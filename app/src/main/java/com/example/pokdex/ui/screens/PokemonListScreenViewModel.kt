package com.example.pokdex.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokdex.Constants
import com.example.pokdex.Resource
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.PokemonListEntry
import kotlinx.coroutines.launch

data class uiState(
    var pokemonList: List<PokemonListEntry> = listOf(),
    var loadingErrorString: String = "",
    var loadingError: Boolean = false,
    var isLoading: Boolean = false,
    var endReached: Boolean = false
)

class PokemonListScreenViewModel(
    private val repository: PokemonRepository
): ViewModel() {

    private var currentPage = 0
    var uiState by mutableStateOf(uiState())
    private set

    init {
        loadPokemonPaginated()
    }
    fun loadPokemonPaginated(){

        viewModelScope.launch {

            uiState.isLoading = true
            val result = repository.getPokemonList(Constants.PAGE_SIZE, currentPage * Constants.PAGE_SIZE)

            when(result){

                is Resource.Success->{
                    if(currentPage * Constants.PAGE_SIZE >= result.data.count) {
                        uiState.endReached = true
                    }
                    val pokemonEntries = result.data.results.mapIndexed{index, entry->
                        val number = if(entry.url.endsWith("/")){
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${number}.png"
                        PokemonListEntry(
                            pokemonName = entry.name,
                            pokemonImageUrl = url
                        )
                    }
                    currentPage++
                    uiState.loadingErrorString = ""
                    uiState.loadingError = false
                    uiState.isLoading = false
                    uiState.pokemonList += pokemonEntries
                }

                is Resource.Error->{
                    uiState.loadingErrorString = result.message
                    uiState.loadingError= true
                }
            }

        }
    }


}