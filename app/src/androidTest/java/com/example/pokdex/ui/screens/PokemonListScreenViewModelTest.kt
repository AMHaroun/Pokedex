package com.example.pokdex.ui.screens

import com.example.pokdex.data.PokemonRepository
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class PokemonListScreenViewModelTest{

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: PokemonRepository

    private lateinit var viewModel: PokemonListScreenViewModel

    @Before
    fun setUp(){
        hiltRule.inject()
        viewModel = PokemonListScreenViewModel(repository)
    }

    @Test
    fun savePokemonList_uiStatePokemonListIsSaved(){

        val cachedPokemonList = viewModel.viewModelState.cachedPokemonList

        viewModel.savePokemonList()

        val pokemonList = (viewModel.uiState as PokemonListScreenUiState.Success).pokemonList
        assertThat(pokemonList == cachedPokemonList)
    }
}