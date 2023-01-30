package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.DataHolder
import com.example.sutk.Entering.IconListOperator
import com.example.sutk.ManageAdapter
import com.example.sutk.R
import com.example.sutk.com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.com.example.sutk.dto.Post.Post
import com.example.sutk.databinding.FragmentProfileBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProfileFragment : Fragment() {

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
        binding.recyclerView.adapter = ManageAdapter(fillList(0))
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("Название $i пароекта") }
        return data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
}