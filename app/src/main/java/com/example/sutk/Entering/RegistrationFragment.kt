package com.example.sutk.Entering

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.R
import com.example.sutk.databinding.FragmentRegistrationBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOk.setOnClickListener {
            findNavController().navigate(R.id.action_RegistrationFragment_to_MainFragment)
        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_RegistrationFragment_to_LoginFragment)
        }

        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_RegistrationFragment_to_MainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}