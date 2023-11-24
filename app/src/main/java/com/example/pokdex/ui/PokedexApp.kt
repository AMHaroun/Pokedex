package com.example.pokdex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            "PokemonDetailScreen/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
            ){backStackEntry ->
            backStackEntry.arguments?.getString("pokemonName")?.let {pokemonNameArgument->
                PokemonDetailScreen(
                    navController = navController,
                    pokemonName = pokemonNameArgument
                )
            }
        }
    }


}