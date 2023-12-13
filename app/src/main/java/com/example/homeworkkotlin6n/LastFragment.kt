package com.example.homeworkkotlin6n

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkkotlin6n.databinding.FragmentLastBinding

class LastFragment : Fragment() {
    private var _binding: FragmentLastBinding? = null
    private val binding: FragmentLastBinding get() = _binding!!
    private val animalsLisiAdapter = AnimalsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLastBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillAnimalsList()
        setupRecycleView()
    }

    private fun fillAnimalsList() {
        val animalsList = listOf(
            Animals(R.drawable.arel1, "Арел", "5см", "3см"),
            Animals(R.drawable.arel2, "Арел", "6см", "4см"),
            Animals(R.drawable.arel3, "Арел", "4см", "5см"),
            Animals(R.drawable.arel4, "Арел", "6см", "6см"),
            Animals(R.drawable.arel5, "Аабсан", "6см", "4см"),
            Animals(R.drawable.arel6, "Аабсан", "6см", "5см"),
            Animals(R.drawable.arel7, "Аабсан", "3см", "6см"),
            Animals(R.drawable.arel8, "Аабсан", "6см", "5см")
        )

        animalsLisiAdapter.setData(animalsList)
    }

    private fun setupRecycleView() {
        binding.rvAnimal.adapter = animalsLisiAdapter

    }
}