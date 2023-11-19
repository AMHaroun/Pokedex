package com.example.pokdex.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokdex.R
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.network.responses.Pokemon
import com.example.pokdex.ui.HeartSaveButton
import com.example.pokdex.ui.SearchBar


@Composable
fun PokemonListScreen(modifier: Modifier, uiState: PokemonListScreenUiState, pageinate: () -> Unit){

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
            PokemonList(Modifier, uiState, pageinate)
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
fun PokemonList(modifier: Modifier, uiState: PokemonListScreenUiState, pageinate:()->Unit){

    LazyColumn(modifier = modifier){
        items(uiState.pokemonList.value.size){
            if(it >= uiState.pokemonList.value.size - 1 && !uiState.endReached) {
                pageinate()
            }
            PokemonInformationCard(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                pokemonImage = R.drawable.ditto_front_default_sample,
                pokemonName = uiState.pokemonList.value[it].pokemonName,
                pokemonIndex = 123,
                showFemaleSymbol = true,
                showMaleSymbol = true,
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
    // Add Fake data
}





@Composable
fun PokemonInformationCard(
    modifier: Modifier = Modifier,
    @DrawableRes pokemonImage: Int,
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
                pokemonImageId = pokemonImage,
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
    PokemonInformationCard(
        modifier = Modifier,
        pokemonImage = R.drawable.ditto_front_default_sample,
        pokemonName = "Ditto",
        pokemonIndex = 234,
        showFemaleSymbol = true,
        showMaleSymbol = true,
        onPokemonSaved = {},
        isPokemonSaved = true,
    )
}




@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    @DrawableRes pokemonImageId: Int
    ){
    // Note that to load images in the ui from a remote service
    // you will likely have to change this to AsyncImage
    Image(
        painter = painterResource(id = pokemonImageId),
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
    PokemonImage(pokemonImageId = R.drawable.ditto_front_default_sample)
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



