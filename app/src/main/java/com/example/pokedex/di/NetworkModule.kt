package com.example.pokedex.di

import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.PokemonNetworkDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val POKEAPI_URL = "https://pokeapi.co/"
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun providePokeApiService():PokeApi{
        val service = Retrofit.Builder()
            .baseUrl(POKEAPI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
        return  service
    }
}
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindPokemonRepository(repository: DefaultPokemonRepository):PokemonReepository

    @Singleton
    @Binds
    abstract fun bindPokemonRemote(repository: PokemonNetworkDataSource):PokemonRemoteDataSource

}