package com.example.sutk.Global

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentMainBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {
    private var currentFragment: Int? = 1
    public var navController: NavigationController? = NavigationController()
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        //context?.let { navController?.setContext(it) }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nav: NavController = findNavController()
//        binding.bottomNavigation.setupWithNavController(nav)
//        NavigationBarView.OnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.page_1 -> {
//                    findNavController().navigate(R.id.action_Pages_1_to_2)
//                    when (currentFragment){
//                        2 -> findNavController().navigate(R.id.action_Pages_2_to_1)
//                        3 -> findNavController().navigate(R.id.action_Pages_3_to_1)
//                        4 -> findNavController().navigate(R.id.action_Pages_4_to_1)
//                        5 -> findNavController().navigate(R.id.action_Pages_5_to_1)
//                        else -> print("lol")
//                    }
//                    currentFragment = 1
//                    return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//                }
//                R.id.page_2 -> {
//                    findNavController().navigate(R.id.action_Pages_1_to_2)
//                    when (currentFragment){
//                        1 -> findNavController().navigate(R.id.action_Pages_1_to_2)
//                        3 -> findNavController().navigate(R.id.action_Pages_3_to_2)
//                        4 -> findNavController().navigate(R.id.action_Pages_4_to_2)
//                        5 -> findNavController().navigate(R.id.action_Pages_5_to_2)
//                        else -> print("lol")
//                    }
//                    currentFragment = 2
//                    return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//                }
//                R.id.page_3 -> {
//                    findNavController().navigate(R.id.action_Pages_1_to_2)
//                    when (currentFragment){
//                        2 -> findNavController().navigate(R.id.action_Pages_2_to_3)
//                        1 -> findNavController().navigate(R.id.action_Pages_1_to_3)
//                        4 -> findNavController().navigate(R.id.action_Pages_4_to_3)
//                        5 -> findNavController().navigate(R.id.action_Pages_5_to_3)
//                        else -> print("lol")
//                    }
//                    currentFragment = 3
//                    return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//                }
//                R.id.page_4 -> {
//                    findNavController().navigate(R.id.action_Pages_1_to_2)
//                    when (currentFragment){
//                        2 -> findNavController().navigate(R.id.action_Pages_2_to_4)
//                        3 -> findNavController().navigate(R.id.action_Pages_3_to_4)
//                        1 -> findNavController().navigate(R.id.action_Pages_1_to_4)
//                        5 -> findNavController().navigate(R.id.action_Pages_5_to_4)
//                        else -> print("lol")
//                    }
//                    currentFragment = 4
//                    return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//                }
//                R.id.page_5 -> {
//                    findNavController().navigate(R.id.action_Pages_1_to_2)
//                    when (currentFragment){
//                        2 -> findNavController().navigate(R.id.action_Pages_2_to_5)
//                        3 -> findNavController().navigate(R.id.action_Pages_3_to_5)
//                        4 -> findNavController().navigate(R.id.action_Pages_4_to_5)
//                        1 -> findNavController().navigate(R.id.action_Pages_1_to_5)
//                        else -> print("lol")
//                    }
//                    currentFragment = 5
//                    return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//                }
//                else -> return@OnItemSelectedListener false
//            }
//            return@OnItemSelectedListener NavigationUI.onNavDestinationSelected(item, nav)
//            // true
//        }

        //binding.bottomNavigation.minimumHeight(binding.bottomNavigation.measuredHeight + 10)
        /*binding.buttonSecond.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}