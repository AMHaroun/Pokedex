package com.example.pokdex.di

import com.example.pokdex.util.Constants
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
object AppModule{
    @Provides
    @Singleton
    fun providesPokemonApiService() : PokemonApiService{
        val baseUrl = Constants.BASE_URL

        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
            .create(PokemonApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonApiService: PokemonApiService) : PokemonRepository {
        return PokemonRepositoryImpl(dataSource = pokemonApiService)
    }



}