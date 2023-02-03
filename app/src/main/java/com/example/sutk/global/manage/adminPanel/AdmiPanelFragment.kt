package com.example.sutk.global.manage.adminPanel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.R
import com.example.sutk.databinding.FragmentAdminPanelBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AdmiPanelFragment : Fragment() {

    private var _binding: FragmentAdminPanelBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdminPanelBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.search.setOnClickListener {
            findNavController().navigate(R.id.action_Admin_to_Search)
        }

        binding.buttonOk.setOnClickListener {
            findNavController().navigate(R.id.action_Admin_to_Manage)
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_Admin_to_Manage)
        }

        binding.buttonDelete.setOnClickListener {
            findNavController().navigate(R.id.action_Admin_to_Manage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}