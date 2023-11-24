package com.example.pokdex.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokdex.ui.screens.PokemonDetailScreen
import com.example.pokdex.ui.screens.PokemonListScreen
import java.util.Locale

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
            arguments = listOf(
                    navArgument("pokemonName") {
                        type = NavType.StringType
                    }
                )
            ){backStackEntry ->

                val pokemonName = remember {
                    backStackEntry.arguments?.getString("pokemonName")
                }
                PokemonDetailScreen(
                    navController = navController,
                    pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: ""
                )
            }
        }

}

