package com.example.pokdex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokdex.R
import com.example.pokdex.ui.HeartSaveButton
import com.example.pokdex.ui.SearchBar


@Composable
fun PokemonListScreen(modifier: Modifier, uiState: PokemonListScreenUiState, paginate: () -> Unit){

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchBar(
            hint = stringResource(R.string.search_bar_hint),
            onValueChange = {},
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.small_padding))
                .fillMaxWidth()
            )

        if(uiState.loadingError){
            Text(
                text = uiState.loadingErrorString
            )
        } else {
            PokemonList(Modifier, uiState, paginate)
        }




    }
    
}

@Preview(
    name = "PokemonListScreen Preview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PokemonListScreenPreview(){
    //TODO: Add fake uiState data
    //PokemonListScreen(modifier = Modifier)
}




@Composable
fun PokemonList(modifier: Modifier, uiState: PokemonListScreenUiState, paginate:()->Unit){

    LazyColumn(modifier = modifier){
        items(uiState.pokemonList.value.size){
            if(it >= uiState.pokemonList.value.size - 1 && !uiState.endReached) {
                paginate()
            }

            val pokemonEntry = uiState.pokemonList.value[it]
            PokemonInformationCard(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                pokemonImageUrl = pokemonEntry.pokemonImageUrl,
                pokemonName = pokemonEntry.pokemonName,
                pokemonIndex = pokemonEntry.pokedexIndexNumber,
                showFemaleSymbol = false,
                showMaleSymbol = false,
                onPokemonSaved = { /*TODO*/ },
                isPokemonSaved = true
            )
        }

    }

}

@Preview(
    name = "PokemonList Preview"
)
@Composable
fun PokemonListPreview(){
    // TODO: Add Fake data
    // PokemonList()
}





@Composable
fun PokemonInformationCard(
    modifier: Modifier = Modifier,
    pokemonImageUrl: String,
    pokemonName: String,
    pokemonIndex: Int,
    showFemaleSymbol: Boolean,
    showMaleSymbol: Boolean,
    onPokemonSaved: ()->Unit,
    isPokemonSaved: Boolean,
){
    Card(
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
                showFemaleSymbol = showFemaleSymbol,
                showMaleSymbol = showMaleSymbol,
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
    // TODO: Add fake data
//    PokemonInformationCard(
//        modifier = Modifier,
//        pokemonImageUrl = R.drawable.ditto_front_default_sample,
//        pokemonName = "Ditto",
//        pokemonIndex = 234,
//        showFemaleSymbol = true,
//        showMaleSymbol = true,
//        onPokemonSaved = {},
//        isPokemonSaved = true,
//    )
}




@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    pokemonImageUrl: String
    ){
    AsyncImage(
        model = pokemonImageUrl,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
    )
    
}

@Preview(
    name = "PokemonImage Preview",
)
@Composable
fun PokemonImagePreview(){
    //TODO: Add fake data
    //PokemonImage(pokemonImageId = R.drawable.ditto_front_default_sample)
}




@Composable
fun PokemonInformation(
    modifier: Modifier = Modifier,
    pokemonName: String,
    showFemaleSymbol: Boolean,
    showMaleSymbol: Boolean,
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

       if(showFemaleSymbol){
            Icon(
                painter = painterResource(id = R.drawable.female_symbol_icon),
                tint = Color.Magenta,
                contentDescription = "Female symbol"
            )
        }
        if(showMaleSymbol){
            Icon(
                painter = painterResource(id = R.drawable.male_symbol_icon),
                tint = Color.Blue,
                contentDescription = "Male symbol"
            )
        }

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
        showFemaleSymbol = true,
        showMaleSymbol = true,
        pokemonIndex = 123,
        onPokemonSaved = {},
        isPokemonSaved = true,
        )
}



