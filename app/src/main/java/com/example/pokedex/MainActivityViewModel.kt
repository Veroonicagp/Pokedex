package com.example.pokedex


import androidx.lifecycle.ViewModel
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.data.remote.PokemonListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository:PokemonReepository
):ViewModel() {
    suspend fun read(): PokemonListResponse {
        return  repository.readAll()
    }
}