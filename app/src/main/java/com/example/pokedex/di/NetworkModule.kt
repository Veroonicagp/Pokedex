package com.example.pokedex.di

import com.example.pokedex.data.remote.PokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

private const val POKEAPI_URL = "hrrps://pokeapi.co/"
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providePokeApiService():PokeApi{
        val service = Retrofit.Builder()
            .baseUrl(POKEAPI_URL)
            .build()
            .create(PokeApi::class.java)
        return  service
    }
}