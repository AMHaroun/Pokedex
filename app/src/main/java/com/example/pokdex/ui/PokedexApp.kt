package com.example.pokdex.ui

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
    
    NavHost(
        navController = navController,
        startDestination = "PokemonListScreen",
        modifier = modifier
    ){
        composable(route = "PokemonListScreen"){
            PokemonListScreen(navController = navController)
        }
        composable(
            exitTransition ={
                slideOutHorizontally(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing
                    ),
                    targetOffsetX = { it }
                )
            },
            enterTransition = {
                slideInHorizontally(
                    animationSpec = tween(
                        durationMillis = 700,
                        easing = LinearOutSlowInEasing
                    ),
                    initialOffsetX = { it }
                )
            },
            route = "PokemonDetailScreen/{pokemonName}",
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

