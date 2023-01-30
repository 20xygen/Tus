package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.DataHolder
import com.example.sutk.Entering.IconListOperator
import com.example.sutk.ManageAdapter
import com.example.sutk.ProfileAdapter
import com.example.sutk.R
import com.example.sutk.com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.com.example.sutk.dto.Post.Post
import com.example.sutk.databinding.FragmentProfileBinding

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
        if ((DataHolder.name == null) or (DataHolder.name == "")) binding.name.setText("Безымянный Искатель")
        else binding.name.setText(DataHolder.name)
        if ((DataHolder.nickname == null) or (DataHolder.nickname == "")) binding.nick.setText("")
        else binding.nick.setText("@" + DataHolder.nickname)
        if ((DataHolder.telegram == null) or (DataHolder.telegram == "")) binding.telegram.setText("")
        else binding.telegram.setText("@" + DataHolder.telegram)
        if ((DataHolder.bio == null) or (DataHolder.bio == "")) binding.bio.setText("Чтобы найти кого-то, не нужно называться кем-то...")
        else binding.bio.setText(DataHolder.bio)

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

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = ProfileAdapter(customFillList())
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
}