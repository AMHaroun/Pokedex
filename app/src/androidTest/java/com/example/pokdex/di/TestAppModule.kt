package com.example.pokdex.di

import com.example.pokdex.Constants
import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.data.PokemonRepositoryImpl
import com.example.pokdex.network.PokemonApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule{
    //@Provides
    //@Singleton
    //fun providesPokemonApiService() : PokemonApiService{

        //TODO :: return fakePokemonApiService
    //}

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonApiService: PokemonApiService) : PokemonRepository {
        return PokemonRepositoryImpl(dataSource = pokemonApiService)
    }



}