package com.example.pokdex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokdex.ui.LoadingSpinner
import com.example.pokdex.ui.NetworkErrorMessage

@Composable
fun PokemonDetailScreen(
    pokemonName: String,
    viewModel: PokemonDetailScreenViewModel = viewModel(factory = PokemonDetailScreenViewModel.Factory),
    navController: NavController,
    modifier: Modifier = Modifier
){

    val uiState = viewModel.uiState
    viewModel.getPokemonData(pokemonName)

    when(uiState){

        is PokemonDetailScreenUiState.Success->{

                PokemonDetails(uiState = uiState)

        }

        is PokemonDetailScreenUiState.Loading->{

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingSpinner()
            }

        }

        is PokemonDetailScreenUiState.Error->{

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NetworkErrorMessage(
                    errorMessage = uiState.errorMessage,
                    onRetry = { viewModel.getPokemonData(pokemonName) }
                )
            }

        }

    }


}



@Composable
fun PokemonDetails(
    uiState: PokemonDetailScreenUiState.Success,
    modifier: Modifier = Modifier
){

    Column {

        PokemonImage(pokemonImageUrl = uiState.pokemon.imageUrl)

    }
}

@Preview(
    name = "PokemonDetails Preview",
    showBackground = true
)
@Composable
fun PokemonDetailsPreview(){

    //TODO: Call PokemonDetails()

}