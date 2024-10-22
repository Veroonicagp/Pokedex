package com.example.pokedex.data

import com.example.pokedex.data.remote.PokemonListResponse

interface PokemonReepository {
    suspend fun readAll():PokemonListResponse
    suspend fun readOne(id:Int):String
}