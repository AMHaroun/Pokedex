package com.example.pokdex.ui.screens

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.pokdex.util.Resource
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface PokemonDetailScreenUiState{

    data class Success(val pokemon: Pokemon) : PokemonDetailScreenUiState
    data class Error(val errorMessage: String): PokemonDetailScreenUiState
    object Loading: PokemonDetailScreenUiState
}
@HiltViewModel
class PokemonDetailScreenViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel(){

    var uiState: PokemonDetailScreenUiState by mutableStateOf(PokemonDetailScreenUiState.Loading)
        private set

    fun getDominantColor(drawable: Drawable, onDominantColorFound: (Color)->Unit){
        // getting the dominant color with the palette library requires a bitmap
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        viewModelScope.launch {
            Palette.from(bitmap).generate { palette ->
                palette?.dominantSwatch?.rgb?.let { colorValue ->
                    onDominantColorFound(Color(colorValue))
                }
            }
        }

    }

    fun getDominantDarkColor(drawable: Drawable, onDominantColorFound: (Color)->Unit){
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        viewModelScope.launch {
            Palette.from(bitmap).generate { palette ->
                palette?.darkMutedSwatch?.rgb?.let { colorValue ->
                    onDominantColorFound(Color(colorValue))
                }
            }
        }

    }

    fun getPokemonData(pokemonName: String){

        viewModelScope.launch {


            when(val result = repository.getPokemon(pokemonName)){

                is Resource.Success ->{

                    /* We don't show all the data that the api provides us, if we need to
                    *  show more data to the ui we can extend the Pokemon data class in the model
                    *  package & then provide the new arguments here */

                    val pokemon = Pokemon(
                        height = result.data.height,
                        id = result.data.id,
                        name = result.data.name,
                        stats = result.data.stats,
                        types = result.data.types,
                        weight = result.data.weight,
                        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${result.data.id}.png"
                    )

                    uiState = PokemonDetailScreenUiState.Success(pokemon)

                }

                is Resource.Error ->{
                    uiState = PokemonDetailScreenUiState.Error(result.message)
                }

            }
        }

    }

}