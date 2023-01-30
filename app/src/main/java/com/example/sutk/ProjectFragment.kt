package com.example.sutk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.databinding.FragmentProjectBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProjectFragment : Fragment() {

    private var _binding: FragmentProjectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOk.setOnClickListener {
            when(DataHolder.projectPlaceType) {
                0 -> findNavController().navigate(R.id.action_ProjectFragment_to_FeedFragment)
                1 -> findNavController().navigate(R.id.action_ProjectFragment_to_ManageFragment)
                4 -> findNavController().navigate(R.id.action_ProjectFragment_to_ProfileFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}