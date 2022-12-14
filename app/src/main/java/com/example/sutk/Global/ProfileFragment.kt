package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sutk.DataHolder
import com.example.sutk.Entering.IconListOperator
import com.example.sutk.R
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
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}