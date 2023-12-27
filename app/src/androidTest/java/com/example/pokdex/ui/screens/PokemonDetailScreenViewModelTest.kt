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
class PokemonDetailScreenViewModelTest{

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: PokemonRepository

    lateinit var viewModel: PokemonDetailScreenViewModel

    @Before
    fun setUp(){
        hiltRule.inject()
        viewModel = PokemonDetailScreenViewModel(repository)
    }

    @Test
    fun getPokemonData_uiStateIsSuccess(){
        viewModel.getPokemonData("ditto")

        assertThat(viewModel.uiState is PokemonDetailScreenUiState.Success)
    }

}