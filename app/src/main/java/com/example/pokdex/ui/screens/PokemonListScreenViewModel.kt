package com.example.pokdex.ui.screens

import androidx.lifecycle.ViewModel
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.PokemonListEntry
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class PokemonListScreenViewModel(
    private val repository: PokemonRepository
): ViewModel() {

}