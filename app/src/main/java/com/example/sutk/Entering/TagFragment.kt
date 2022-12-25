package com.example.sutk.Entering

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sutk.R
import com.example.sutk.databinding.FragmentTagBinding
import com.github.okdroid.checkablechipview.CheckableChipView
import me.saket.inboxrecyclerview.animation.ItemExpandAnimator
import me.saket.inboxrecyclerview.dimming.DimPainter
import me.saket.inboxrecyclerview.page.PageCollapseEligibilityHapticFeedback


class TagFragment  : Fragment() {

    private var _binding: FragmentTagBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTagBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        var recyclerView = binding.recycle
//        recyclerView.itemExpandAnimator = ItemExpandAnimator.scale() // or split() / none()
//        recyclerView.dimPainter = DimPainter.listAndPage(Color.WHITE, alpha = 0.65f)
//
//        recyclerView.expandablePage = binding.expand.also {
////            var toolbar = (activity as AppCompatActivity?)!!.supportActionBar.
//            it.pushParentToolbarOnExpand(binding.tagLabel)
//            it.addOnPullListener(PageCollapseEligibilityHapticFeedback(it))
//        }
//
//        var recyclerViewAdapter = binding.recycle.getAdapter()
//        recyclerView.expandItem(binding.textView11.id.toLong())
////        recyclerViewAdapter.onItemClick = { clickedItem ->
////            // Load or update your content inside the page here.
////            recyclerView.expandItem(clickedItem.adapterId)
////        }

        binding.buttonOk.setOnClickListener {
            findNavController().navigate(R.id.action_TagFragment_to_MainFragment)
        }

        binding.buttonMore.setOnClickListener {
            print("lol")
        }

        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_TagFragment_to_MainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}