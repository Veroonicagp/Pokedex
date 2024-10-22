package com.example.pokedex.data.remote

interface PokemonRemoteDataSource {
    suspend fun readAll():PokemonListResponse
    suspend fun readOne(id:Int):String
}