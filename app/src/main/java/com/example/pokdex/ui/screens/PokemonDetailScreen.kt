package com.example.pokdex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun PokemonDetailScreen(
    pokemonName: String,
    viewModel: PokemonDetailScreenViewModel = viewModel(factory = PokemonDetailScreenViewModel.Factory),
    navController: NavController,
    modifier: Modifier = Modifier
){
    val uiState = remember{ viewModel.uiState }

    when(uiState){

        is PokemonDetailScreenUiState.Success->{

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

            NetworkErrorMessage(
                errorMessage = uiState.errorMessage,
                onRetry = { viewModel.getPokemonData(pokemonName) }
            )

        }

    }


}

// TODO: move this to CommonUiComposables.kt
@Composable
fun NetworkErrorMessage(
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    onRetry:()->Unit
){

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = errorMessage ?: "A network error has occurred",
            style = MaterialTheme.typography.labelLarge
        )

        Button(onClick = { onRetry }) {
            Text(text = "Retry")
        }

    }

}

@Preview(
    name = "NetworkErrorMessage Preview",
    showBackground = true
)
@Composable
fun NetworkErrorMessagePreview(){

    NetworkErrorMessage(errorMessage = null){}

}



// TODO: Move this to CommonUiComposables.kt
@Composable
fun LoadingSpinner(modifier: Modifier = Modifier){

    CircularProgressIndicator(modifier = modifier)
}

@Preview(
    name = "LoadingSpinner Preview",
    showBackground = true
)
@Composable
fun LoadingSpinnerPreview(){

    LoadingSpinner()

}



@Composable
fun PokemonDetails(
    modifier: Modifier = Modifier
){

}