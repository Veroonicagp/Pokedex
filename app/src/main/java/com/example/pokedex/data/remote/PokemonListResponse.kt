package com.example.pokedex.data.remote


data class PokemonListResponse(
    val count: Long,
    val next: String,
    val previous: Any?,
    val results: List<Result>,
)

data class Result(
    val name: String,
    val url: String,
)
