package com.example.pokdex.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokdex.Constants
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.PokemonListEntry
import kotlinx.coroutines.launch


class PokemonListScreenViewModel(
    private val repository: PokemonRepository
): ViewModel() {

    private var currentPage = 0

    var pokemonList = mutableStateOf<List<PokemonListEntry>>(listOf())
    var loadingError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    fun loadPokemonPaginated(){
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPokemonList(Constants.PAGE_SIZE, currentPage * Constants.PAGE_SIZE)
            if(currentPage * Constants.PAGE_SIZE >= result.count) {
                endReached.value = true
            }
            val pokemonEntries = result.results.mapIndexed{index, entry->
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
            loadingError.value = ""
            isLoading.value = false
            pokemonList.value += pokemonEntries
        }
    }


}