package com.example.pokedex.data

interface PokemonReepository {
    suspend fun readAll():String
    suspend fun readOne(id:Int):String
}