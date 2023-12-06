package com.example.pokdex.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokdex.R
import com.example.pokdex.model.PokemonListEntry
import com.example.pokdex.ui.HeartSaveButton
import com.example.pokdex.ui.LoadingSpinner
import com.example.pokdex.ui.PokemonImage
import com.example.pokdex.ui.SearchBar


@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PokemonListScreenViewModel = viewModel(factory = PokemonListScreenViewModel.Factory),
){

    val uiState = remember{ viewModel.uiState }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            hint = stringResource(R.string.search_bar_hint),
            onSearch = {
                viewModel.searchPokemonList(it)
            },
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.small_padding))
                .fillMaxWidth()
            )

        if(uiState.loadingError){
            Text(
                text = uiState.loadingErrorString
            )
        } else {

            PokemonList(
                modifier = Modifier,
                uiState = uiState,
                navController = navController,
                paginate = { viewModel.loadPokemonPaginated() }
            )


        }
    }
    
}



@Composable
fun PokemonList(
    modifier: Modifier,
    uiState: PokemonListScreenUiState,
    navController: NavController,
    paginate:()->Unit,
){

    LazyColumn(modifier = modifier){
        items(uiState.pokemonList.value.size){
            if(it >= uiState.pokemonList.value.size - 1 && !uiState.endReached) {
                paginate()
            }

            val pokemonEntry = uiState.pokemonList.value[it]
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                PokemonInformationCard(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .clickable {
                            navController.navigate(
                                "PokemonDetailScreen/${pokemonEntry.pokemonName.lowercase()}"
                            )
                        },
                    pokemonImageUrl = pokemonEntry.pokemonImageUrl,
                    pokemonName = pokemonEntry.pokemonName,
                    pokemonIndex = pokemonEntry.pokedexIndexNumber,
                    onPokemonSaved = { /*TODO*/ },
                    isPokemonSaved = true,
                )
                if (uiState.isLoading) {
                    LoadingSpinner()
                }
            }
        }

    }

}

@SuppressLint("UnrememberedMutableState")
@Preview(
    name = "PokemonList Preview",
    showBackground = true
)
@Composable
fun PokemonListPreview(){
    PokemonList(
        modifier = Modifier,
        navController = rememberNavController(),
        uiState = PokemonListScreenUiState(
            pokemonList = mutableStateOf(
                    listOf(
                    PokemonListEntry(
                        pokemonName = "Ditto",
                        pokemonImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/132.png",
                        pokedexIndexNumber = 123
                    ),
                    PokemonListEntry(
                        pokemonName = "Ditto",
                        pokemonImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/132.png",
                        pokedexIndexNumber = 321
                    )

                )
            )
        ),
        paginate = {}
    )

}





@Composable
fun PokemonInformationCard(
    modifier: Modifier = Modifier,
    pokemonImageUrl: String,
    pokemonName: String,
    pokemonIndex: Int,
    onPokemonSaved: ()->Unit,
    isPokemonSaved: Boolean,
){
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
    ){
        Row{
            PokemonImage(
                pokemonImageUrl = pokemonImageUrl,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.small_padding))
                )

            PokemonInformation(
                pokemonName = pokemonName,
                pokemonIndex = pokemonIndex,
                onPokemonSaved = onPokemonSaved,
                isPokemonSaved = isPokemonSaved,
            )

        }
    }
}

@Preview(
    name = "PokemonInformationCard Preview"
)
@Composable
fun PokemonInformationCardPreview(){

    PokemonInformationCard(
        modifier = Modifier,
        pokemonImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/132.png",
        pokemonName = "Ditto",
        pokemonIndex = 234,
        onPokemonSaved = {},
        isPokemonSaved = true,
    )
}



@Composable
fun PokemonInformation(
    modifier: Modifier = Modifier,
    pokemonName: String,
    pokemonIndex: Int,
    onPokemonSaved: () -> Unit,
    isPokemonSaved: Boolean,
){

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = pokemonName,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(start = dimensionResource(R.dimen.medium_padding))
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "#$pokemonIndex",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(end = dimensionResource(id = R.dimen.medium_padding))
            )
            HeartSaveButton(
                onClick = { onPokemonSaved() },
                saved = isPokemonSaved,
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.medium_padding))
                )

        }

    }

}

@Preview(
    name = "PokemonInformation Preview"
)
@Composable
fun PokemonInformationPreview(){
    PokemonInformation(
        modifier = Modifier,
        pokemonName = "Ditto",
        pokemonIndex = 123,
        onPokemonSaved = {},
        isPokemonSaved = true,
        )
}



