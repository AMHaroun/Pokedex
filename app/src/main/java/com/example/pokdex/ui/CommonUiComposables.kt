package com.example.pokdex.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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


@Composable
fun NetworkErrorMessage(
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    onRetry:()->Unit
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Text(
            text = errorMessage ?: "A network error has occurred",
            style = MaterialTheme.typography.labelLarge
        )

        Button(onClick = { onRetry }) {
            Text(text = "Retry")
        }

    }

}

@Preview(
    name = "NetworkErrorMessage Preview",
    showBackground = true
)
@Composable
fun NetworkErrorMessagePreview(){

    NetworkErrorMessage(errorMessage = null) {}

}



@Composable
fun LoadingSpinner(modifier: Modifier = Modifier){

    CircularProgressIndicator(modifier = modifier)
}

@Preview(
    name = "LoadingSpinner Preview",
    showBackground = true
)
@Composable
fun LoadingSpinnerPreview(){

    LoadingSpinner()

}



@Composable
fun BackButton(navigateBack: ()->Unit, modifier: Modifier = Modifier){

    IconButton(onClick = { navigateBack() }, modifier = modifier) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Back button"
        )
    }

}

@Preview(
    name = "BackButton Preview",
    showBackground = true
)
@Composable
fun BackButtonPreview(){

    BackButton(navigateBack = {}, Modifier)

}


