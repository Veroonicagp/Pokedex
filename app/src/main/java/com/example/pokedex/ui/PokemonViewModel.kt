package com.example.pokedex.ui


import androidx.lifecycle.ViewModel
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.data.remote.PokemonListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository:PokemonReepository
):ViewModel() {
    suspend fun read(): PokemonListResponse {
        return  repository.readAll()
    }
}