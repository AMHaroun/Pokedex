package com.example.pokdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.pokdex.ui.PokedexApp
import com.example.pokdex.ui.screens.PokemonInformationCard
import com.example.pokdex.ui.screens.PokemonList
import com.example.pokdex.ui.screens.PokemonListScreen
import com.example.pokdex.ui.screens.PokemonListScreenViewModel
import com.example.pokdex.ui.screens.PokemonListScreenViewModelFactory
import com.example.pokdex.ui.theme.PokèdexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokèdexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokedexApp(modifier = Modifier, owner = this)
                }
            }
        }
    }
}
