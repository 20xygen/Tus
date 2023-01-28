package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.PostAdapter
import com.example.sutk.com.example.sutk.Global.ItemSkeleton
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentFeedBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    public var navController: NavigationController? = NavigationController()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        var adapter = PostAdapter(fillList(0))
        binding.recyclerView.adapter = adapter
        adapter.addRange(fillList(5))


        navController?.setController(findNavController())
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
//        binding.recycle_inbox
    }

    private fun fillList(k: Int): MutableList<ItemSkeleton> {
        var data = mutableListOf<ItemSkeleton>()
        var cur: ItemSkeleton? = null
        for (i in 1+k..5+k){
            cur = ItemSkeleton("Название" +  i.toString() + "проекта", 0, "Полное описание проекта", "Краткое описание проекта", i, "Мистер Никто", "TWNTxygen", 0)
            println(cur.label)
            data.add(cur)
        }
        return data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}