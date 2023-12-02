package com.example.pokdex.model

import androidx.compose.ui.graphics.Color
import com.example.pokdex.model.PokemonTypes.*

enum class PokemonTypes(val color: Color) {
    GROUND(Color(0xFFE0C068)),
    GRASS(Color(0xFF78C850)),
    POISON(Color(0xFFA040A0)),
    FIRE(Color(0xFFf08030)),
    FLYING(Color(0xFFA890F0)),
    WATER(Color(0xFF78C850)),
    BUG(Color(0xFFA8B820)),
    NORMAL(Color(0xFFA8A878)),
    ELECTRIC(Color(0xFF78C850)),
    ICE(Color(0xFF98D8D8)),
    FIGHTING(Color(0xFFC03028)),
    PSYCHIC(Color(0xFFF85888)),
    ROCK(Color(0xFFB8A038)),
    GHOST(Color(0xFF705898)),
    DRAGON(Color(0xFF7038F8)),
    DARK(Color(0xFF705848)),
    STEEL(Color(0xFFB8B8D0)),
    FAIRY(Color(0xFFEE99AC))
}

    fun getPokemonTypeColor(pokemonType: String): Color {
        return when (pokemonType.uppercase()) {
            GROUND.name -> GROUND.color
            GRASS.name -> GRASS.color
            POISON.name -> POISON.color
            FIRE.name -> FIRE.color
            FLYING.name -> FLYING.color
            WATER.name -> WATER.color
            BUG.name -> BUG.color
            NORMAL.name -> NORMAL.color
            ELECTRIC.name -> ELECTRIC.color
            ICE.name -> ICE.color
            FIGHTING.name -> FIGHTING.color
            PSYCHIC.name -> PSYCHIC.color
            ROCK.name -> ROCK.color
            GHOST.name -> GHOST.color
            DRAGON.name -> DRAGON.color
            DARK.name -> DARK.color
            STEEL.name -> STEEL.color
            FAIRY.name -> FAIRY.color
            else -> Color.White
        }
    }
