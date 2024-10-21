package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonRemoteDataSource
import javax.inject.Inject

class DefaultPokemonRepository
    @Inject constructor(
        private val remotedataSource: PokemonRemoteDataSource
    ):PokemonReepository {
    override suspend fun readAll(): String {
        TODO("Not yet implemented")
    }

    override suspend fun readOne(id: Int): String {
        TODO("Not yet implemented")
    }

}