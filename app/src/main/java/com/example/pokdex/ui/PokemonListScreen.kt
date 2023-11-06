package com.example.pokdex.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.pokdex.R
import com.example.pokdex.model.PokemonType

@Composable
fun PokemonListScreen(modifier: Modifier){

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


    }
    
}

@Preview(
    name = "PokemonListScreen Preview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PokemonListScreenPreview(){
    PokemonListScreen(modifier = Modifier)
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
    pokemonFirstType: PokemonType,
    pokemonSecondType: PokemonType? = null,
    pokemonThirdType: PokemonType? = null
){
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ){
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.small_padding))
        ) {
            PokemonImage(pokemonImageId = pokemonImage)

            PokemonInformation(
                pokemonName = pokemonName,
                showFemaleSymbol = showFemaleSymbol,
                showMaleSymbol = showMaleSymbol,
                pokemonIndex = pokemonIndex,
                onPokemonSaved = onPokemonSaved,
                isPokemonSaved = isPokemonSaved,
                pokemonFirstType = pokemonFirstType
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
        pokemonFirstType = PokemonType.NORMAL
    )
}







@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    @DrawableRes pokemonImageId: Int
    ){
    
    Image(
        painter = painterResource(id = pokemonImageId),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
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
    /* Pokemon are known to have a maximum of three types
     * Variables also determine the order in which types are shown */
    pokemonFirstType: PokemonType,
    pokemonSecondType: PokemonType? = null,
    pokemonThirdType: PokemonType? = null,
){

    Row() {
        Column {
            Text(
                text = pokemonName,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )

            /* Add a switch statement to determine the pokemon's type
             * and display that types image */
        }

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
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "#$pokemonIndex",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.alpha(0.6f)
            )
            HeartSaveButton(onClick = { onPokemonSaved() }, saved = isPokemonSaved)

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
        pokemonFirstType = PokemonType.NORMAL
        )
}