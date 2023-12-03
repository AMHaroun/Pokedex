package com.example.pokdex.model

import androidx.compose.ui.graphics.Color
import com.example.pokdex.model.PokemonTypes.*

enum class PokemonTypes(val color: Color) {
    GROUND(Color(0xFFCC9F4F)),
    GRASS(Color(0xFF71C558)),
    POISON(Color(0xFFB468B7)),
    FIRE(Color(0xFFEA7A3C)),
    FLYING(Color(0xFF7DA6DE)),
    WATER(Color(0xFF539AE2)),
    BUG(Color(0xFF94BC4A)),
    NORMAL(Color(0xFFAAB09F)),
    ELECTRIC(Color(0xFFE5C531)),
    ICE(Color(0xFF70CBD4)),
    FIGHTING(Color(0xFFCB5F48)),
    PSYCHIC(Color(0xFFE5709B)),
    ROCK(Color(0xFFB2A061)),
    GHOST(Color(0xFF846AB6)),
    DRAGON(Color(0xFF6A7BAF)),
    DARK(Color(0xFF736C75)),
    STEEL(Color(0xFF89A1B0)),
    FAIRY(Color(0xFFE397D1))
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
