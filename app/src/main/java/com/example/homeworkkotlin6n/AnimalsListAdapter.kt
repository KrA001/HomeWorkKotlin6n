package com.example.homeworkkotlin6n

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkkotlin6n.databinding.AnimalsItemBinding

class AnimalsListAdapter : RecyclerView.Adapter<AnimalsListAdapter.AnimalViewHolder>() {
    private var animals = listOf<Animals>()
    fun setData(data: List<Animals>) {
        animals = data
    }

    class AnimalViewHolder(private val binding: AnimalsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(animals: Animals) = with(binding) {
            ivGaller.setImageResource(animals.animalImage)
            tvText.text = animals.name
            tvWool.text = animals.claws
            tvEars.text = animals.beak
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.onBind(animals[position])

    }
}