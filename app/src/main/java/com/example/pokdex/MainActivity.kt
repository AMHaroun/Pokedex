package com.example.pokdex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.pokdex.data.PokemonRemoteDataSource
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.ui.screens.PokemonInformationCard
import com.example.pokdex.ui.screens.PokemonListScreen
import com.example.pokdex.ui.screens.PokemonListScreenViewModel
import com.example.pokdex.ui.screens.PokemonListScreenViewModelFactory
import com.example.pokdex.ui.theme.PokèdexTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val factory = PokemonListScreenViewModelFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this, factory).get(PokemonListScreenViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            PokèdexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                    }
                }
            }
        }
    }
}
