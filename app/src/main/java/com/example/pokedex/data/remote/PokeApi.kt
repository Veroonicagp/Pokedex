package com.example.pokedex.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("api/v2/pokemon")
    suspend fun read(): PokemonListResponse
    @GET("api/v2/pokemon/{id}")
    suspend fun readOne(@Path("id") id:Int):String

}