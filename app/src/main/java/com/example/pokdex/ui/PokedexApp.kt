package com.example.pokdex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.pokdex.ui.screens.PokemonList
import com.example.pokdex.ui.screens.PokemonListScreen
import com.example.pokdex.ui.screens.PokemonListScreenViewModel
import com.example.pokdex.ui.screens.PokemonListScreenViewModelFactory

@Composable
fun PokedexApp(
    modifier: Modifier,
    owner: ViewModelStoreOwner
){
    val factory = PokemonListScreenViewModelFactory()
    val viewModel = ViewModelProvider(owner, factory).get(PokemonListScreenViewModel::class.java)

    PokemonListScreen(
        modifier = modifier,
        uiState = viewModel.uiState,
        pageinate = { viewModel.loadPokemonPaginated() }
    )


}