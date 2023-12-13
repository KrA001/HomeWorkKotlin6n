package com.example.homeworkkotlin6n

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homeworkkotlin6n.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCounterZer.text = count.toString()
        setupCount()
        savedInstanceState?.let {
            count = it.getInt(NUMBER, 0)
            binding.tvCounterZer.text = count.toString()
        }
    }

    private fun setupCount() = with(binding) {
        btnIncrement.setOnClickListener {
            if (count < 10) {
                count++
                tvCounterZer.text = count.toString()
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container_view2, LastFragment())
                    .addToBackStack("Last Fragment")
                    .commit()
            }
        }
        btnDecrement.setOnClickListener {
            if (count > 0) {
                count--
                tvCounterZer.text = count.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putInt(NUMBER, count)
        }
    }

    companion object {
        const val NUMBER = "count"

    }
}