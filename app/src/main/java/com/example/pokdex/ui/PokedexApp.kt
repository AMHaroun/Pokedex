package com.example.pokdex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokdex.ui.screens.PokemonListScreen
import com.example.pokdex.ui.screens.PokemonListScreenViewModel

@Composable
fun PokedexApp(
    modifier: Modifier,
){

    PokemonListScreen()


}