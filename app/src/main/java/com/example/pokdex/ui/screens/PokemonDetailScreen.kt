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
import com.example.pokdex.model.Pokemon
import com.example.pokdex.network.responses.Stat
import com.example.pokdex.network.responses.StatX
import com.example.pokdex.network.responses.Type
import com.example.pokdex.network.responses.TypeX
import com.example.pokdex.ui.BackButton
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
            Column {
                BackButton(navigateBack = { navController.popBackStack() })
            }

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

    }
}

@Preview(
    name = "PokemonDetails Preview",
    showBackground = true
)
@Composable
fun PokemonDetailsPreview(){

    PokemonDetails(
        uiState = PokemonDetailScreenUiState.Success(
            pokemon = Pokemon(
                height = 10,
                id = 123,
                name = "Ditto",
                stats = listOf(
                    Stat(10, 10, StatX("ExampleStatX", "StatXUrl")),
                ),
                types = listOf(
                    Type(10, TypeX("ExampleTypeX", "TypeXUrl")),
                ),
                weight = 10,
                imageUrl = "imageUrl"
            )
        )
    )

}