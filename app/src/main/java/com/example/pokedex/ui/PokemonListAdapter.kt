package com.example.pokedex.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.remote.Pokemon
import com.example.pokedex.databinding.PokemonListItemBinding

class PokemonListAdapter(): ListAdapter<Pokemon, PokemonListAdapter.PokemonListViewHolder>(PokemonDiffCallBack){
    inner class PokemonListViewHolder(private val binding: PokemonListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pokemon:Pokemon){
            binding.nombrePokemon.text = nombre.nombre
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):PokemonListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}