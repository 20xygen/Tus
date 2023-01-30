package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.PostAdapter
import com.example.sutk.com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.com.example.sutk.dto.Post.Post
import com.example.sutk.com.example.sutk.dto.User.User
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentFeedBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        // DataHolder.context =
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        var adapter = PostAdapter(fillList(0))
        DataHolder.adapter = adapter
        binding.recyclerView.adapter = adapter



//        CoroutineScope(Dispatchers.IO).launch {
//            val user = Client.getUserById(0)
//            withContext(Dispatchers.Main){
//                adapter.addItem(user)
//            }
//        }

//        navController?.setController(findNavController())

    }

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