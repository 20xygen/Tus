package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.DataHolder
import com.example.sutk.ManageAdapter
import com.example.sutk.PostAdapter
import com.example.sutk.R
import com.example.sutk.com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.com.example.sutk.dto.Post.Post
import com.example.sutk.databinding.FragmentManageBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ManageFragment : Fragment() {
    fun switchToAdminPanel() = findNavController().navigate(R.id.action_Manage_to_Admin)

    private var _binding: FragmentManageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentManageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataHolder.manageFragment = this

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = ManageAdapter(fillList(0))
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

    }

//    private fun fillList(): List<String> {
//        val data = mutableListOf<String>()
//        (0..30).forEach { i -> data.add("Название $i пароекта") }
//        return data
//    }

    private fun fillList(k: Int): MutableList<Post> {
        var data = mutableListOf<Post>()
        var cur: Post? = null
        for (i in 1+k..10+k){
            cur = Post(i, "Название " + i.toString() + " проекта", "userTelegram",
                "Здесь можно прочитать краткое описание  " + i.toString() + " проекта", listOf<Int>(), 0, 0,
                listOf<String>(), listOf<MainInfoPost>(), listOf<MainInfoPost>())
            println(cur.title)
            data.add(cur)
        }
        return data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}