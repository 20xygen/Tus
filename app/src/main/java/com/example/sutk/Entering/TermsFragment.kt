package com.example.sutk.Entering

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sutk.R
import com.example.sutk.databinding.FragmentTermsBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TermsFragment : Fragment() {
    private var clickedMore: Boolean? = false

    private var _binding: FragmentTermsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTermsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.buttonSkip.setOnClickListener {
            if (clickedMore == true) {
                clickedMore = false
                val paramsMore = binding.termsLabel.layoutParams as MarginLayoutParams
                paramsMore.setMargins(0, 0, 0, 25)
                binding.termsLabel.layoutParams = paramsMore
                binding.termsText.setGravity(Gravity.CENTER)
                binding.termsText.setText(R.string.terms_less)
                binding.buttonSkip.setText(R.string.view_more)
            }
            else {
                clickedMore = true
                val paramsLess = binding.termsLabel.layoutParams as MarginLayoutParams
                paramsLess.setMargins(0, 1800, 0, 25)
                binding.termsLabel.layoutParams = paramsLess
                binding.termsText.setGravity(Gravity.LEFT)
                binding.termsText.setText(R.string.terms_more)
                binding.buttonSkip.setText(R.string.view_less)
            }
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_TermsFragment_to_RegistrationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}