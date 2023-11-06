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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
    pokemonNumber: Int,
    showFemaleSymbol: Boolean = true,
    showMaleSymbol: Boolean = true,
    onSaved: ()->Unit,
    saved: Boolean = false
){
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ){
        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.small_padding))
        ) {
            Image(
                painter = painterResource(id = pokemonImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.
                    clip(MaterialTheme.shapes.medium)
            )

            Column {
                Text(
                    text = pokemonName,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.medium_padding),
                            end = dimensionResource(id = R.dimen.small_padding)
                        )
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.male_symbol_icon),
                contentDescription = "Male symbol",
                tint = Color.Blue,
            )
            Icon(
                painter = painterResource(id = R.drawable.female_symbol_icon),
                contentDescription = "Female symbol",
                tint = Color.Magenta,
            )

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "#$pokemonNumber",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.alpha(0.6f)
                )
                HeartSaveButton(onClick = { onSaved() }, saved = saved )
            }

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
        pokemonImage = R.drawable.ic_launcher_background,
        pokemonName = "Chandler",
        pokemonNumber = 5,
        onSaved = {},
    )
}