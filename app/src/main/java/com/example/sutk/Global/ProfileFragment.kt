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
import com.example.sutk.ProfileAdapter
import com.example.sutk.R
import com.example.sutk.databinding.FragmentProfileBinding
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
class ProfileFragment : Fragment() {
    fun switchToProject() {
        DataHolder.projectPlaceType = 4
        findNavController().navigate(R.id.action_ProfileFragment_to_ProjectFragment)
    }

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if ((DataHolder.name == null) or (DataHolder.name == "")) binding.titleLabel.setText("Безымянный Искатель")
//        else binding.titleLabel.setText(DataHolder.name)
//        if ((DataHolder.nickname == null) or (DataHolder.nickname == "")) binding.nick.setText("")
//        else binding.nick.setText("@" + DataHolder.nickname)
//        if ((DataHolder.telegram == null) or (DataHolder.telegram == "")) binding.telegram.setText("")
//        else binding.telegram.setText("@" + DataHolder.telegram)
//        if ((DataHolder.bio == null) or (DataHolder.bio == "")) binding.bio.setText("Чтобы найти кого-то, не нужно называться кем-то...")
//        else binding.bio.setText(DataHolder.bio)

        binding.titleLabel.setText(DataHolder.ultimateUser?.name)
        binding.nick.setText(DataHolder.ultimateUser?.login)
        binding.telegram.setText(DataHolder.ultimateUser?.tg)
        binding.bio.setText(DataHolder.ultimateUser?.description)

        DataHolder.profileFragment = this

        when (DataHolder.iconNumber) {
            0 -> binding.imageView2.setImageResource(R.drawable.icon_anime)
            1 -> binding.imageView2.setImageResource(R.drawable.icon_batman)
            2 -> binding.imageView2.setImageResource(R.drawable.icon_chewbacca)
            3 -> binding.imageView2.setImageResource(R.drawable.icon_cookie)
            4 -> binding.imageView2.setImageResource(R.drawable.icon_dog)
            5 -> binding.imageView2.setImageResource(R.drawable.icon_futurama)
            6 -> binding.imageView2.setImageResource(R.drawable.icon_groot)
            7 -> binding.imageView2.setImageResource(R.drawable.icon_gunter)
            8 -> binding.imageView2.setImageResource(R.drawable.icon_homer)
            9 -> binding.imageView2.setImageResource(R.drawable.icon_jetpack)
            10 -> binding.imageView2.setImageResource(R.drawable.icon_naruto)
            11 -> binding.imageView2.setImageResource(R.drawable.icon_neo)
            12 -> binding.imageView2.setImageResource(R.drawable.icon_robber)
            13 -> binding.imageView2.setImageResource(R.drawable.icon_smurf)
            14 -> binding.imageView2.setImageResource(R.drawable.icon_sonic)
            15 -> binding.imageView2.setImageResource(R.drawable.icon_spongebob)
            16 -> binding.imageView2.setImageResource(R.drawable.icon_stich)
            17 -> binding.imageView2.setImageResource(R.drawable.icon_tom)
            18 -> binding.imageView2.setImageResource(R.drawable.icon_woody)
            19 -> binding.imageView2.setImageResource(R.drawable.icon_yellow)
            20 -> binding.imageView2.setImageResource(R.drawable.icon_yoda)
        }

        var adapter = ProfileAdapter(mutableListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
        try {
            if (DataHolder.demiIsOn) throw Exception("Demo is on")
            CoroutineScope(Dispatchers.IO).launch {
                val user = Client.getUserById(2)
                withContext(Dispatchers.Main){
                    DataHolder.user = user
                }
            }
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
            CoroutineScope(Dispatchers.IO).launch {
                val userPost = Client.getUserPostById(2)
                val post = mutableListOf<Post>()
                for (i in userPost.postList) {
                    post.add(Client.getPostById(i))
                }
                withContext(Dispatchers.Main) {
                    adapter.addRange(post)
                }
            }
        } catch (e: Exception){
            for (i in 0 until  DataHolder.fakePosts.size) if (DataHolder.loginedUser.login == DataHolder.fakePosts[i].creatorLogin) adapter.addItem(DataHolder.fakePosts[i])
        }

    }

    private fun customFillList(): MutableList<Post>{
        var data = mutableListOf<Post>()
        var defUsers = listOf<User>(User("20xygen", "TWNTxygen", "Славный парень", 1, "DenBari2005@yandex.ru"),
            User("shlepa", "shlepa05", "У самурая нет цели, только путь", 2, "kokorev_vd_09_20@1511.ru"),
            User("denchik", "legendaProisvodnih", "Купи симкарту", 1, "KUPI_SIMKARTU_CHEL@yandex.ru"))
        var defTags = listOf<Tag>(Tag("Тригонометрия", "Математика"), Tag("Т. Относительности", "Физика"), Tag("Аллергология", "Медицина"))
        var i: Int = 0

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
}