package com.example.pokdex.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
        Column(modifier = Modifier.fillMaxWidth()) {
            BackButton(navigateBack = { navigateBack() })
            Text(
                text = "#${uiState.pokemon.id} - National Pokédex",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = uiState.pokemon.name,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 16.dp)
            )
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
                height = 3,
                weight = 40,
                id = 132,
                name = "Ditto",
                stats = listOf(
                    Stat(48, 1,
                        StatX("hp", "https://pokeapi.co/api/v2/stat/1/")
                    ),
                    Stat(48, 0,
                        StatX("attack", "https://pokeapi.co/api/v2/stat/2/" )
                    ),
                    Stat(48, 0,
                        StatX("defense", "https://pokeapi.co/api/v2/stat/3/")
                    ),
                    Stat(48,0,
                        StatX("special-attack", "https://pokeapi.co/api/v2/stat/4/")
                    ),
                    Stat(48, 0,
                        StatX("special-defense", "https://pokeapi.co/api/v2/stat/5/")
                    ),
                    Stat(48, 0,
                        StatX("speed", "https://pokeapi.co/api/v2/stat/6/")
                    )
                ),
                types = listOf(
                    Type(1,
                        TypeX("normal", "https://pokeapi.co/api/v2/type/1")
                    ),
                ),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/132.svg"
            )
        )
    )

}



@Composable
fun PokemonDetailsCard(modifier: Modifier = Modifier, uiState: PokemonDetailScreenUiState.Success){

    Card(
        modifier = modifier.fillMaxSize()
    ) {
       Row(
           horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .fillMaxWidth()
               .height(128.dp)
       ){
           Column(horizontalAlignment = Alignment.CenterHorizontally) {
               Icon(
                   painter = painterResource(id = R.drawable.weight_icon),
                   contentDescription = "Pokemon weight",
                   modifier = Modifier.size(64.dp)
               )
               Text(
                   text = "${uiState.pokemon.weight} lbs",
                   style = MaterialTheme.typography.labelLarge,
                   fontWeight = FontWeight.Bold
               )
           }

           Spacer(modifier = Modifier.size(64.dp))

           Column(horizontalAlignment = Alignment.CenterHorizontally) {
               Icon(
                   painter = painterResource(id = R.drawable.height_icon),
                   contentDescription = "Pokemon height",
                   modifier = Modifier.size(64.dp)
               )
               Text(
                   text = "${uiState.pokemon.height} ft",
                   style = MaterialTheme.typography.labelLarge,
                   fontWeight = FontWeight.Bold
               )
           }
       }

        LazyRow(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            items(uiState.pokemon.types.size) {
                val pokemonType = uiState.pokemon.types[it]

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        //TODO: Provide pokemonTypes specific color here
                        .background(Color.LightGray)
                ) {
                    Text(
                        text = pokemonType.type.name.uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                }

            }

        }

        LazyColumn(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
        ) {
            items(uiState.pokemon.stats.size) {
                val pokemonStat = uiState.pokemon.stats[it]

                Text(
                    text = pokemonStat.stat.name.uppercase(),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
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
                height = 3,
                weight = 40,
                id = 132,
                name = "Ditto",
                stats = listOf(
                    Stat(48, 1,
                        StatX("hp", "https://pokeapi.co/api/v2/stat/1/")
                    ),
                    Stat(48, 0,
                        StatX("attack", "https://pokeapi.co/api/v2/stat/2/" )
                    ),
                    Stat(48, 0,
                        StatX("defense", "https://pokeapi.co/api/v2/stat/3/")
                    ),
                    Stat(48,0,
                        StatX("special-attack", "https://pokeapi.co/api/v2/stat/4/")
                    ),
                    Stat(48, 0,
                        StatX("special-defense", "https://pokeapi.co/api/v2/stat/5/")
                    ),
                    Stat(48, 0,
                        StatX("speed", "https://pokeapi.co/api/v2/stat/6/")
                    )
                ),
                types = listOf(
                    Type(1,
                        TypeX("normal", "https://pokeapi.co/api/v2/type/1")
                    ),
                ),
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/132.svg"
            )
        )
    )

}



@Composable
fun PokemonStatBar(
    statValue: Int,
    statMaxValue: Int,
    statBarColor: Color,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .clip(CircleShape)
            .background(Color.LightGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(statValue / statMaxValue.toFloat())
                // statValue/statMaxValue.toFloat() determines how much of the bar is filled
                .clip(CircleShape)
                .background(statBarColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = statValue.toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun PokemonStatBarPreview(){
    PokemonStatBar(statValue = 10, statMaxValue = 100, statBarColor = Color.Blue)
}