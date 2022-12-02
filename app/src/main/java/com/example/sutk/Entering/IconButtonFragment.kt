package com.example.sutk.Entering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sutk.R
import com.example.sutk.databinding.FragmentIconButtonBinding

class IconButtonFragment  : Fragment() {
    private var selected = false

    private var _binding: FragmentIconButtonBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIconButtonBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
        binding.imageButton.setOnClickListener {
            if (selected) {
                binding.imageView.setImageResource(R.drawable.plate_simple)
                selected = false
            }
            else {
                binding.imageView.setImageResource(R.drawable.plate_selected)
                selected = false
            }
        }
    }

    public fun getSelected(): Boolean {
        return selected
    }

    public fun click(): Boolean {
        if (selected) {
            binding.imageView.setImageResource(R.drawable.plate_simple)
            selected = false
            return false
        }
        else {
            binding.imageView.setImageResource(R.drawable.plate_selected)
            selected = false
            return true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}