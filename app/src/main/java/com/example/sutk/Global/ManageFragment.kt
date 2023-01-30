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
    fun switchToProject() {
        DataHolder.projectPlaceType = 1
        findNavController().navigate(R.id.action_Manage_to_ProjectFragment)
    }
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
        binding.recyclerView.adapter = ManageAdapter(customFillList())
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

    }

//    private fun fillList(): List<String> {
//        val data = mutableListOf<String>()
//        (0..30).forEach { i -> data.add("Название $i пароекта") }
//        return data
//    }

    private fun customFillList(): MutableList<Post>{
        var data = mutableListOf<Post>()


        data.add(Post(0, "Онлайн-расписания", "userTelegram",
            "Приложение для автоматического составления школьного расписания средствами ML", listOf<Int>(), 0, 0,
            listOf("0", "2", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(1, "Team Up System", "userTelegram",
            "Приложение для поиска единомышленников для объединения в проектные команды.", listOf<Int>(), 0, 0,
            listOf("2", "7", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(2, "Happy Meeting", "userTelegram",
            "Приложение для создание веселых сборов", listOf<Int>(), 0, 0,
            listOf("2", "2", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(3, "Анти-прокрастинатор", "userTelegram",
            "Мобильное приложение для борьбы с прокрастинацией", listOf<Int>(), 0, 0,
            listOf("2", "0", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(4, "Cooker", "userTelegram",
            "Мобильная социальная сеть для любителей готовки", listOf<Int>(), 0, 0,
            listOf("2", "4", "6"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(5, "Lumet mobile", "userTelegram",
            "Мобильное приложение Lumet", listOf<Int>(), 0, 0,
            listOf("0", "1", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(6, "Планировщик бюджета", "userTelegram",
            "Мобильное для планирования семейного бюджета и отслеживания трат", listOf<Int>(), 0, 0,
            listOf("6", "2", "6"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        data.add(Post(7, "Головоломки", "userTelegram",
            "Головоломки с машиной Тьюринга", listOf<Int>(), 0, 0,
            listOf("2", "0", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

        return data
    }

    private fun fillList(k: Int): MutableList<Post> {
        var data = mutableListOf<Post>()
        var cur: Post? = null
        var tagList: List<String> = listOf("1", "2", "3")
        for (i in 1+k..10+k){

            cur = Post(i, "Название " + i.toString() + " проекта", "userTelegram",
                "Здесь можно прочитать краткое описание  " + i.toString() + " проекта", listOf<Int>(), 0, 0,
                tagList, listOf<MainInfoPost>(), listOf<MainInfoPost>())
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