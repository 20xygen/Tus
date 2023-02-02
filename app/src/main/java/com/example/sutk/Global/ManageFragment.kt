package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.ManageAdapter
import com.example.sutk.PostAdapter
import com.example.sutk.R
import com.example.sutk.databinding.FragmentManageBinding
import com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.dto.Post.Post
import com.example.sutk.dto.Tag.Tag
import com.example.sutk.dto.User.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
//        binding.recyclerView.adapter = ManageAdapter(customFillList())
        var adapter = ManageAdapter(mutableListOf())
        binding.recyclerView.adapter = adapter
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }


        CoroutineScope(Dispatchers.IO).launch {
            val userPost = Client.getUserTeamById(0)
            val post = mutableListOf<Post>()
            for (i in userPost.userTeam) {
                post.add(Client.getPostById(i))
            }
            withContext(Dispatchers.Main) {
                adapter.addRange(post)
            }
        }
    }

//    private fun fillList(): List<String> {
//        val data = mutableListOf<String>()
//        (0..30).forEach { i -> data.add("Название $i пароекта") }
//        return data
//    }

    private fun customFillList(): MutableList<Post>{
        var data = mutableListOf<Post>()
        var defUsers = listOf<User>(User("20xygen", "TWNTxygen", "Славный парень", 1, "DenBari2005@yandex.ru"),
            User("shlepa", "shlepa05", "У самурая нет цели, только путь", 2, "kokorev_vd_09_20@1511.ru"),
            User("denchik", "legendaProisvodnih", "Купи симкарту", 1, "KUPI_SIMKARTU_CHEL@yandex.ru"))
        var defTags = listOf<Tag>(Tag("Тригонометрия", "Математика"), Tag("Т. Относительности", "Физика"), Tag("Аллергология", "Медицина"))
        var i: Int = 0

        data.add(
            Post(0, "Онлайн-расписания", 0,
                "Приложение для автоматического составления школьного расписания средствами ML",
                "Денис Г.", "Приложение для автоматического составления школьного расписания средствами ML",
                listOf<User>(), 0, 0,
                listOf<Tag>(Tag("Тригонометрия", "Математика"), Tag("Т. Относительности", "Физика"), Tag("Аллергология", "Медицина")), listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Team Up System", 0,
                "Приложение для поиска единомышленников для объединения в проектные команды.",
                "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Lumet mobile", 0,
                "Мобильное приложение Lumet",
                "AnyLogin", "Мобильное приложение Lumet",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Онлайн-расписания", 0,
                "Приложение для автоматического составления школьного расписания средствами ML",
                "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Team Up System", 0,
                "Приложение для поиска единомышленников для объединения в проектные команды.",
                "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Lumet mobile", 0,
                "Мобильное приложение Lumet",
                "AnyLogin", "Мобильное приложение Lumet",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Онлайн-расписания", 0,
                "Приложение для автоматического составления школьного расписания средствами ML",
                "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Team Up System", 0,
                "Приложение для поиска единомышленников для объединения в проектные команды.",
                "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Lumet mobile", 0,
                "Мобильное приложение Lumet",
                "AnyLogin", "Мобильное приложение Lumet",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Онлайн-расписания", 0,
                "Приложение для автоматического составления школьного расписания средствами ML",
                "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Team Up System", 0,
                "Приложение для поиска единомышленников для объединения в проектные команды.",
                "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        data.add(
            Post(i++, "Lumet mobile", 0,
                "Мобильное приложение Lumet",
                "AnyLogin", "Мобильное приложение Lumet",
                listOf<User>(), 0, 0,
                defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        return data
    }

//    private fun fillList(k: Int): MutableList<Post> {
//        var data = mutableListOf<Post>()
//        var cur: Post? = null
//        var tagList: List<String> = listOf("1", "2", "3")
//        for (i in 1+k..10+k){
//
//            cur = Post(i, "Название " + i.toString() + " проекта", "userTelegram",
//                "Здесь можно прочитать краткое описание  " + i.toString() + " проекта", listOf<Int>(), 0, 0,
//                tagList, listOf<MainInfoPost>(), listOf<MainInfoPost>())
//            println(cur.title)
//            data.add(cur)
//        }
//        return data
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
