package com.example.sutk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.databinding.PostSkeletonManageBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ManageBlockFragment : Fragment() {

    private var _binding: PostSkeletonManageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PostSkeletonManageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settings.setOnClickListener {
            println("admin panel")
            findNavController().navigate(R.id.action_Pages_Manage_to_Admin)
        }
    }

    public fun activeAdminPanel(view: View){
        findNavController().navigate(R.id.action_Pages_Manage_to_Admin)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}