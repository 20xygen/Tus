package com.example.sutk.global.manage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentManageRootBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ManageRootFragment : Fragment() {
    private var currentFragment: Int? = 1
    public var navController: NavigationController? = NavigationController()
    private var _binding: FragmentManageRootBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentManageRootBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //navController?.setController(findNavController())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}