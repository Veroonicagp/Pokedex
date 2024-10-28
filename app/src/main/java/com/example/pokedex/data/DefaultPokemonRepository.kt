package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonListResponse
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository
    @Inject constructor(
        private val remotedataSource: PokemonRemoteDataSource
    ):PokemonReepository {

    override suspend fun readAll(): PokemonListResponse {
        val pokemons = remotedataSource.readAll()
        return pokemons
    }

    override suspend fun readOne(id: Int): String {
        TODO("Not yet implemented")
    }

}