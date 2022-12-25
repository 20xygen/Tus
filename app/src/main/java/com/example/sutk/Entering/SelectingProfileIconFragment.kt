package com.example.sutk.Entering

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.sutk.R
import com.example.sutk.databinding.FragmentSelectingProfileIconBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SelectingProfileIconFragment : Fragment() {
    private var listIconListOperator = IconListOperator()

    private var _binding: FragmentSelectingProfileIconBinding? = null

//    private val button_array = arrayOfNulls<ImageButton>(21)
//    private val view_array = arrayOfNulls<ImageButton>(21)
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSelectingProfileIconBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listIconListOperator.init(binding)
        listIconListOperator.setListener()
        listIconListOperator.setUnique()

        binding.buttonOk.setOnClickListener {
            findNavController().navigate(R.id.action_SelectingProfileIconFragment_to_TagFragment)
        }

        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_SelectingProfileIconFragment_to_TagFragment)
        }

        //view_array[0] = binding.button9.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}