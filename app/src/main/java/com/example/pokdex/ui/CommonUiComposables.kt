package com.example.pokdex.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

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
    onSearch: (String)->Unit
){
    var text by remember{ mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(text)
        },
        shape = MaterialTheme.shapes.extraLarge,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        placeholder = {Text(hint)},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        modifier = modifier
    )

}

@Preview(
    showBackground = true,
    name = "SearchBar Preview"
)
@Composable
fun SearchBarPreview(){
    SearchBar(hint = "Search", onSearch = {})
}




