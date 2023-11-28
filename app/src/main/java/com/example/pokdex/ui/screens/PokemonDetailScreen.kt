package com.example.pokdex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokdex.R
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
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailScreenViewModel = viewModel(factory = PokemonDetailScreenViewModel.Factory)
){

    val uiState = viewModel.uiState
    viewModel.getPokemonData(pokemonName)

    when(uiState){

        is PokemonDetailScreenUiState.Success->{

            PokemonDetails(
                uiState = uiState,
                modifier = modifier,
                navigateBack = { navController.popBackStack() }
            )
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
    navigateBack: ()->Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            BackButton(navigateBack = { navigateBack() })
        }
        PokemonImage(pokemonImageUrl = uiState.pokemon.imageUrl)
        PokemonDetailsCard(uiState = uiState, modifier = Modifier.padding(20.dp))
    }


}

@Preview(
    name = "PokemonDetails Preview",
    showBackground = true
)
@Composable
fun PokemonDetailsPreview(){

    PokemonDetails(
        navigateBack = {},
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



@Composable
fun PokemonDetailsCard(modifier: Modifier = Modifier, uiState: PokemonDetailScreenUiState.Success){

    Card(
        modifier = modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                Icon(
                    painter = painterResource(R.drawable.height_icon),
                    contentDescription = "Pokemon height",
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(50.dp)
                )
                Text(
                    text = "${uiState.pokemon.height} m",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = uiState.pokemon.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "#${uiState.pokemon.id}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Icon(
                    painter = painterResource(id = R.drawable.weight_icon),
                    contentDescription = "Pokemon weight",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(55.dp)
                )

                Text(
                    text = "${uiState.pokemon.weight} kg",
                    style = MaterialTheme.typography.titleLarge,
                )
            }

        }

        LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            items(uiState.pokemon.types.size){
                Text(
                    text = uiState.pokemon.types[it].type.name,
                    modifier = Modifier
                        .weight(1f)
                        .padding(24.dp)
                )
            }

        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(uiState.pokemon.stats.size){
                Text(
                    text = uiState.pokemon.stats[it].stat.name,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 16.dp)
                )
            }
        }

    }

}



@Preview
@Composable
fun PokemonDetailsCardPreview(){

    PokemonDetailsCard(
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