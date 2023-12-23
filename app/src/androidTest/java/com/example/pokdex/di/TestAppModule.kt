package com.example.pokdex.di

import com.example.pokdex.data.PokemonRepository
import com.example.pokdex.data.PokemonRepositoryImpl
import com.example.pokdex.network.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule{
    @Provides
    @Singleton
    fun providesPokemonApiService() : PokemonApiService{
        return FakePokemonApiService()
    }

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonApiService: PokemonApiService) : PokemonRepository {
        return PokemonRepositoryImpl(dataSource = pokemonApiService)
    }



}