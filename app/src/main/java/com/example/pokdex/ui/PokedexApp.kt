package com.example.pokdex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokdex.ui.screens.PokemonDetailScreen
import com.example.pokdex.ui.screens.PokemonListScreen

@Composable
fun PokedexApp(
    modifier: Modifier,
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "PokemonListScreen"){
        composable("PokemonListScreen"){
            PokemonListScreen(navController = navController)
        }
        composable("PokemonDetailScreen"){
            PokemonDetailScreen(navController = navController)
        }
    }


}