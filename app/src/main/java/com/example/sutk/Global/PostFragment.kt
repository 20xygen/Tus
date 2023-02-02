package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.Entering.IconListOperator
import com.example.sutk.R
import com.example.sutk.databinding.FragmentPostBinding
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
class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postIcon.setOnClickListener {
            findNavController().navigate(R.id.action_PostFragment_to_SelectingPostIconFragment)
        }

        binding.buttonOk.setOnClickListener {
            findNavController().navigate(R.id.action_PostFragment_to_PostCreatedFragment)

            val post = Post(0, binding.title.text.toString(), 0,
                binding.descriptionShort.text.toString(),
                DataHolder.loginedUser.login, binding.description.text.toString(),
                listOf<User>(DataHolder.loginedUser), 0, 0,
                listOf<Tag>(Tag("Android", "Информатика"), Tag("UI", "Информатика"), Tag("UX", "Информатика")), listOf<MainInfoPost>(), listOf<MainInfoPost>())
            CoroutineScope(Dispatchers.IO).launch {
                println(post)
                Client.createPost(post)
            }
        }

        when (DataHolder.postIconNumber) {
            0 -> binding.postIcon?.setImageResource(R.drawable.ip__1_)
            1 -> binding.postIcon?.setImageResource(R.drawable.ip__2_)
            2 -> binding.postIcon?.setImageResource(R.drawable.ip__3_)
            3 -> binding.postIcon?.setImageResource(R.drawable.ip__4_)
            4 -> binding.postIcon?.setImageResource(R.drawable.ip__5_)
            5 -> binding.postIcon?.setImageResource(R.drawable.ip__6_)
            6 -> binding.postIcon?.setImageResource(R.drawable.ip__7_)
            7 -> binding.postIcon?.setImageResource(R.drawable.ip__8_)
            8 -> binding.postIcon?.setImageResource(R.drawable.ip__9_)
            9 -> binding.postIcon?.setImageResource(R.drawable.ip__10_)
            10 -> binding.postIcon?.setImageResource(R.drawable.ip__11_)
            11 -> binding.postIcon?.setImageResource(R.drawable.ip__12_)
            12 -> binding.postIcon?.setImageResource(R.drawable.ip__13_)
            13 -> binding.postIcon?.setImageResource(R.drawable.ip__14_)
            14 -> binding.postIcon?.setImageResource(R.drawable.ip__15_)
            15 -> binding.postIcon?.setImageResource(R.drawable.ip__16_)
            16 -> binding.postIcon?.setImageResource(R.drawable.ip__17_)
            17 -> binding.postIcon?.setImageResource(R.drawable.ip__18_)
            18 -> binding.postIcon?.setImageResource(R.drawable.ip__19_)
            19 -> binding.postIcon?.setImageResource(R.drawable.ip__20_)
            20 -> binding.postIcon?.setImageResource(R.drawable.ip__21_)
            21 -> binding.postIcon?.setImageResource(R.drawable.ip__22_)
            22 -> binding.postIcon?.setImageResource(R.drawable.ip__23_)
            23 -> binding.postIcon?.setImageResource(R.drawable.ip__24_)
            24 -> binding.postIcon?.setImageResource(R.drawable.ip__25_)
            25 -> binding.postIcon?.setImageResource(R.drawable.ip__26_)
            26 -> binding.postIcon?.setImageResource(R.drawable.ip__27_)
            27 -> binding.postIcon?.setImageResource(R.drawable.ip__28_)
            28 -> binding.postIcon?.setImageResource(R.drawable.ip__29_)
            29 -> binding.postIcon?.setImageResource(R.drawable.ip__30_)
            30 -> binding.postIcon?.setImageResource(R.drawable.ip__31_)
            31 -> binding.postIcon?.setImageResource(R.drawable.ip__32_)
            32 -> binding.postIcon?.setImageResource(R.drawable.ip__33_)
            33 -> binding.postIcon?.setImageResource(R.drawable.ip__34_)
            34 -> binding.postIcon?.setImageResource(R.drawable.ip__35_)
            35 -> binding.postIcon?.setImageResource(R.drawable.ip__36_)
            36 -> binding.postIcon?.setImageResource(R.drawable.ip__37_)
            37 -> binding.postIcon?.setImageResource(R.drawable.ip__38_)
            38 -> binding.postIcon?.setImageResource(R.drawable.ip__39_)
            39 -> binding.postIcon?.setImageResource(R.drawable.ip__40_)
            40 -> binding.postIcon?.setImageResource(R.drawable.ip__41_)
            41 -> binding.postIcon?.setImageResource(R.drawable.ip__42_)
            42 -> binding.postIcon?.setImageResource(R.drawable.ip__43_)
            43 -> binding.postIcon?.setImageResource(R.drawable.ip__44_)
            44 -> binding.postIcon?.setImageResource(R.drawable.ip__45_)
            45 -> binding.postIcon?.setImageResource(R.drawable.ip__46_)
            46 -> binding.postIcon?.setImageResource(R.drawable.ip__47_)
            47 -> binding.postIcon?.setImageResource(R.drawable.ip__48_)
            48 -> binding.postIcon?.setImageResource(R.drawable.ip__49_)
            49 -> binding.postIcon?.setImageResource(R.drawable.ip__50_)
            50 -> binding.postIcon?.setImageResource(R.drawable.ip__51_)
            51 -> binding.postIcon?.setImageResource(R.drawable.ip__52_)
            52 -> binding.postIcon?.setImageResource(R.drawable.ip__53_)
            53 -> binding.postIcon?.setImageResource(R.drawable.ip__54_)
            54 -> binding.postIcon?.setImageResource(R.drawable.ip__55_)
            55 -> binding.postIcon?.setImageResource(R.drawable.ip__56_)
            56 -> binding.postIcon?.setImageResource(R.drawable.ip__57_)
            57 -> binding.postIcon?.setImageResource(R.drawable.ip__58_)
            58 -> binding.postIcon?.setImageResource(R.drawable.ip__59_)
            59 -> binding.postIcon?.setImageResource(R.drawable.ip__60_)
            60 -> binding.postIcon?.setImageResource(R.drawable.ip__61_)
            61 -> binding.postIcon?.setImageResource(R.drawable.ip__62_)
            62 -> binding.postIcon?.setImageResource(R.drawable.ip__63_)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}