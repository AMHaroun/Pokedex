package com.example.pokdex.ui

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokdex.ui.theme.PokèdexTheme

@Composable
fun HeartSaveButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit,
    saved: Boolean
){
    Icon(
        imageVector = if(saved)Icons.Default.Favorite else Icons.Default.FavoriteBorder,
        contentDescription = "Save button",
        tint = Color.Red,
        modifier = modifier
            .clickable { onClick() }
    )

}

@Preview(
    name = "HeartSaveButton Preview"
)
@Composable
fun HeartSaveButtonPreview(){
    HeartSaveButton(modifier = Modifier, onClick = {}, saved = false)
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String,
    onValueChange: ()->Unit
){
    OutlinedTextField(
        value = hint,
        onValueChange = {onValueChange()},
        shape = MaterialTheme.shapes.extraLarge,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        modifier = modifier
    )

}

@Preview(
    showBackground = true,
    name = "SearchBar Preview"
)
@Composable
fun SearchBarPreview(){
    SearchBar(hint = "Search", onValueChange = {})
}




