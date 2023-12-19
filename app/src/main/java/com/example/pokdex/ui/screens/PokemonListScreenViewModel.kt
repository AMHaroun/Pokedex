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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface PokemonListScreenUiState{
    data class Success(
        var pokemonList: MutableState<List<PokemonListEntry>> = mutableStateOf(listOf()),
        var loadingAdditionalEntries: MutableState<Boolean> = mutableStateOf(false),
        var endReached: Boolean = false,
        var isSearching: MutableState<Boolean> = mutableStateOf(false)
    ) : PokemonListScreenUiState
    data class Error(val errorMessage: String) : PokemonListScreenUiState
    object Loading : PokemonListScreenUiState
}

data class PokemonListScreenViewModelState(
    var currentPage: Int = 0,
    var cachedPokemonList: List<PokemonListEntry> = listOf()
)

@HiltViewModel
class PokemonListScreenViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    private val viewModelState = PokemonListScreenViewModelState()

    var uiState: PokemonListScreenUiState by mutableStateOf(PokemonListScreenUiState.Loading)
    private set

    init {
        loadPokemonPaginated()
    }

    fun savePokemonList(){
        uiState = PokemonListScreenUiState.Success(
            pokemonList = mutableStateOf(viewModelState.cachedPokemonList)
        )
    }

    fun searchPokemonList(searchQuery: String){

        /* We modify the uiState PokemonList based on the search query & then restore it from
           the cached PokemonList when we are done */

        viewModelScope.launch(Dispatchers.Default) {
            if(searchQuery.isEmpty()){
                uiState = PokemonListScreenUiState.Success(
                    pokemonList = mutableStateOf(viewModelState.cachedPokemonList)
                )
                (uiState as PokemonListScreenUiState.Success).isSearching.value = false
                return@launch
            }
            (uiState as PokemonListScreenUiState.Success).isSearching.value = true
            val results = (uiState as PokemonListScreenUiState.Success).pokemonList.value.filter {
                it.pokemonName.contains(searchQuery.trim(), ignoreCase = true)
            }
            uiState = PokemonListScreenUiState.Success(
                pokemonList = mutableStateOf(results),
                isSearching = mutableStateOf(true)
            )
        }
    }

    fun loadPokemonPaginated(){

        viewModelScope.launch {

            if(uiState is PokemonListScreenUiState.Success){
                (uiState as PokemonListScreenUiState.Success).loadingAdditionalEntries.value = true
            }

            val result = repository.getPokemonList(
                Constants.PAGE_SIZE,
                viewModelState.currentPage * Constants.PAGE_SIZE
            )

            when(result){

                is Resource.Success->{
                    if(viewModelState.currentPage * Constants.PAGE_SIZE >= result.data.count) {
                        (uiState as PokemonListScreenUiState.Success).endReached = true
                    }
                    /* Network response does not provide us with image urls but we can get the image
                       url by using the pokemonIndexNumber along with the githubusercontent link */

                    val pokemonEntries = result.data.results.mapIndexed{index, entry->
                        val number = if(entry.url.endsWith("/")){
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${number}.png"
                        PokemonListEntry(
                            pokemonName = entry.name,
                            pokemonImageUrl = url,
                            pokedexIndexNumber = number.toInt()
                        )
                    }
                    viewModelState.currentPage++
                    viewModelState.cachedPokemonList += pokemonEntries
                    uiState = PokemonListScreenUiState.Success(
                        pokemonList = mutableStateOf(viewModelState.cachedPokemonList)
                    )
                }

                is Resource.Error->{
                    uiState = PokemonListScreenUiState.Error(errorMessage =  result.message)
                }
            }

        }
    }

}