package com.example.sutk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sutk.databinding.LikeAnimBinding
import com.example.sutk.LikeAnimButton2
import com.example.sutk.LikeAnimFragment

class LikeAnimFragment : Fragment(R.layout.like_anim) {
    private var _binding: LikeAnimBinding? = null
    private val binding: LikeAnimBinding
        get() {
            return _binding!!
        }
    private var likeCount = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LikeAnimBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            likeCount = likeCount++
            binding.btn.setUIState(LikeAnimButton.UIState.Like(likeCount), isAnim = true)
        }
    }
}