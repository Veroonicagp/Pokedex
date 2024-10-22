package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pokedex.R
import com.example.pokedex.data.PokemonReepository
import com.example.pokedex.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class PokemonListFragment : Fragment() {
    //no olvidar importar fragment en gradel
    private val viewModel: PokemonViewModel by viewModels()
    @Inject
    lateinit var repository: PokemonReepository
    private lateinit var binding: FragmentPokemonListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(
            inflater,
            container,
            false
        )
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PokemonListAdapter()
        val rv = binding.rvPokemon
        rv.adapter = adapter
        (rv.adapter as PokemonListAdapter).submitList(repository.readAll())
        viewLifecycleOwner.lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                val pokemons = viewModel.read()
                binding.pokemonResult.text = pokemons.toString()

                }
            }

        }


    }



}