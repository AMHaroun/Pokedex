package com.example.pokdex.ui.screens

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokdex.MainActivity
import com.example.pokdex.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class PokemonListScreenTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.activity.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "PokemonListScreen"){
                composable("PokemonListScreen"){
                    PokemonListScreen(navController = navController)
                }
            }
        }
    }

    @Test
    fun searchBar_isVisible(){
        composeRule.onNodeWithTag(TestTags.SEARCH_BAR).assertIsDisplayed()
    }

    @Test
    fun searchBar_isClickable(){
        composeRule.onNodeWithTag(TestTags.SEARCH_BAR).assertHasClickAction()
    }



}