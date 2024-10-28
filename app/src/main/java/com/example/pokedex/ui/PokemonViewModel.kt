package com.example.pokedex.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.data.remote.Pokemon
import com.example.pokedex.data.remote.PokemonListResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository:PokemonReepository
):ViewModel() {

    private val _uiState = MutableStateFlow<PokemonListUiState>(PokemonListUiState.Loading)
    //??
    val uiState: StateFlow<PokemonListUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                DefaultPokemonRepository.setStream.collect {
                        pokemonList ->
                    if (pokemonList.isEmpty()) _uiState.value = PokemonListUiState.Loading
                    else _uiState.value = PokemonListUiState.Success(pokemonList)
                }
            }
        }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                DefaultPokemonRepository.read()
            }
        }

    }
}
sealed class PokemonListUiState() {
    data object Loading: PokemonListUiState()
    class Success(val pokemonList: List<Pokemon>): PokemonListUiState()
    class Error(val message: String): PokemonListUiState()
}