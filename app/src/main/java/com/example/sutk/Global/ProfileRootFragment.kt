package com.example.sutk.Global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentProfileRootBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileRootFragment : Fragment() {
    private var currentFragment: Int? = 1
    public var navController: NavigationController? = NavigationController()
    private var _binding: FragmentProfileRootBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileRootBinding.inflate(inflater, container, false)
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