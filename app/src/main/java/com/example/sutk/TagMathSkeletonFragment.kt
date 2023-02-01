package com.example.sutk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sutk.databinding.TagMathSkeletonBinding

class TagMathSkeletonFragment : Fragment() {

    private var _binding: TagMathSkeletonBinding? = null
    private val binding get() = _binding!!
    private var title: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TagMathSkeletonBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.textView.text = title
        _binding = null
    }

    fun setTitle(s: String) {
        this.title = s
    }

}