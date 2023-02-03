package com.example.sutk.Entering

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.R
import com.example.sutk.databinding.FragmentTagBinding
import com.example.sutk.dto.Tag.Tag
import com.github.okdroid.checkablechipview.CheckableChipView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

//        CoroutineScope(Dispatchers.IO).launch {
//            val allTag = Client.getAllTag()
//            println(allTag)
//        }

        try{
            if (DataHolder.demiIsOn) throw Exception("Demo is on")
            CoroutineScope(Dispatchers.IO).launch {
                val allTag = Client.getAllTag()
                println(allTag)
                println("+")
                withContext(Dispatchers.Main){
                    for (i in allTag) DataHolder.listOfAllTags?.add(i)
                }
            }
        } catch (e: Exception){
            DataHolder.listOfAllTags = DataHolder.allFixedTags
        }


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
        var holder = DataHolder()

        binding.buttonOk.setOnClickListener {
//            binding.math1.onCheckedChangeListener = { view: CheckableChipView, isChecked: Boolean ->
//                print("math1")
//            }
//            Log.w("Math1", binding.math1.isChecked.toString())
//            print(binding.math1.id)
            var countOfSubject: List<Int> = listOf(6 + DataHolder.ndt, 8 + DataHolder.ndt,
                14 + DataHolder.ndt, 10 + DataHolder.ndt, 10 + DataHolder.ndt,
                8 + DataHolder.ndt, 4 + DataHolder.ndt, 8 + DataHolder.ndt)
            var prefCountOfSubject: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
            for (i in 1 until prefCountOfSubject.size) prefCountOfSubject[i] = prefCountOfSubject[i-1] + countOfSubject[i-1]

            var mathTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[0]) mathTags.add(false)
            var physicsTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[1]) physicsTags.add(false)
            var infoTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[2]) infoTags.add(false)
            var isTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[3]) isTags.add(false)
            var langTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[4]) langTags.add(false)
            var medicineTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[5]) medicineTags.add(false)
            var economyTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[6]) economyTags.add(false)
            var otherTags = mutableListOf<Boolean>(); for (i in 0 until countOfSubject[7]) otherTags.add(false)


            println(DataHolder.listOfAllTags)
            var tagList: MutableList<Tag> = DataHolder.listOfAllTags as MutableList<Tag>

            // DataHolder.listOfAllTags = tagList

            mathTags[0] = binding.math1.isChecked
            mathTags[1] = binding.math2.isChecked
            mathTags[2] = binding.math3.isChecked
            mathTags[3] = binding.math4.isChecked
            mathTags[4] = binding.math5.isChecked
            mathTags[5] = binding.math6.isChecked
            mathTags[6] = binding.mathD1.isChecked
            mathTags[7] = binding.mathD2.isChecked
            mathTags[8] = binding.mathD3.isChecked
            mathTags[9] = binding.mathD4.isChecked
            mathTags[10] = binding.mathD5.isChecked
            mathTags[11] = binding.mathD6.isChecked
            mathTags[12] = binding.mathD7.isChecked
            mathTags[13] = binding.mathD8.isChecked

            physicsTags[0] = binding.physics1.isChecked
            physicsTags[1] = binding.physics2.isChecked
            physicsTags[2] = binding.physics3.isChecked
            physicsTags[3] = binding.physics4.isChecked
            physicsTags[4] = binding.physics5.isChecked
            physicsTags[5] = binding.physics6.isChecked
            physicsTags[6] = binding.physics7.isChecked
            physicsTags[7] = binding.physics8.isChecked
            physicsTags[8] = binding.physicsD1.isChecked
            physicsTags[9] = binding.physicsD2.isChecked
            physicsTags[10] = binding.physicsD3.isChecked
            physicsTags[11] = binding.physicsD4.isChecked
            physicsTags[12] = binding.physicsD5.isChecked
            physicsTags[13] = binding.physicsD6.isChecked
            physicsTags[14] = binding.physicsD7.isChecked
            physicsTags[15] = binding.physicsD8.isChecked

            infoTags[0] = binding.info1.isChecked
            infoTags[1] = binding.info2.isChecked
            infoTags[2] = binding.info3.isChecked
            infoTags[3] = binding.info4.isChecked
            infoTags[4] = binding.info5.isChecked
            infoTags[5] = binding.info6.isChecked
            infoTags[6] = binding.info7.isChecked
            infoTags[7] = binding.info8.isChecked
            infoTags[8] = binding.info9.isChecked
            infoTags[9] = binding.info10.isChecked
            infoTags[10] = binding.info11.isChecked
            infoTags[11] = binding.info12.isChecked
            infoTags[12] = binding.info13.isChecked
            infoTags[13] = binding.info14.isChecked
            infoTags[14] = binding.infoD1.isChecked
            infoTags[15] = binding.infoD2.isChecked
            infoTags[16] = binding.infoD3.isChecked
            infoTags[17] = binding.infoD4.isChecked
            infoTags[18] = binding.infoD5.isChecked
            infoTags[19] = binding.infoD6.isChecked
            infoTags[20] = binding.infoD7.isChecked
            infoTags[21] = binding.infoD8.isChecked

            isTags[0] = binding.is1.isChecked
            isTags[1] = binding.is2.isChecked
            isTags[2] = binding.is3.isChecked
            isTags[3] = binding.is4.isChecked
            isTags[4] = binding.is5.isChecked
            isTags[5] = binding.is6.isChecked
            isTags[6] = binding.is7.isChecked
            isTags[7] = binding.is8.isChecked
            isTags[8] = binding.is9.isChecked
            isTags[9] = binding.is10.isChecked
            isTags[10] = binding.isD1.isChecked
            isTags[11] = binding.isD2.isChecked
            isTags[12] = binding.isD3.isChecked
            isTags[13] = binding.isD4.isChecked
            isTags[14] = binding.isD5.isChecked
            isTags[15] = binding.isD6.isChecked
            isTags[16] = binding.isD7.isChecked
            isTags[17] = binding.isD8.isChecked

            langTags[0] = binding.lang1.isChecked
            langTags[1] = binding.lang2.isChecked
            langTags[2] = binding.lang3.isChecked
            langTags[3] = binding.lang4.isChecked
            langTags[4] = binding.lang5.isChecked
            langTags[5] = binding.lang6.isChecked
            langTags[6] = binding.lang7.isChecked
            langTags[7] = binding.lang8.isChecked
            langTags[8] = binding.lang9.isChecked
            langTags[9] = binding.lang10.isChecked
            langTags[10] = binding.langD1.isChecked
            langTags[11] = binding.langD2.isChecked
            langTags[12] = binding.langD3.isChecked
            langTags[13] = binding.langD4.isChecked
            langTags[14] = binding.langD5.isChecked
            langTags[15] = binding.langD6.isChecked
            langTags[16] = binding.langD7.isChecked
            langTags[17] = binding.langD8.isChecked

            medicineTags[0] = binding.medicine1.isChecked
            medicineTags[1] = binding.medicine2.isChecked
            medicineTags[2] = binding.medicine3.isChecked
            medicineTags[3] = binding.medicine4.isChecked
            medicineTags[4] = binding.medicine5.isChecked
            medicineTags[5] = binding.medicine6.isChecked
            medicineTags[6] = binding.medicine7.isChecked
            medicineTags[7] = binding.medicine8.isChecked
            medicineTags[8] = binding.medicineD1.isChecked
            medicineTags[9] = binding.medicineD2.isChecked
            medicineTags[10] = binding.medicineD3.isChecked
            medicineTags[11] = binding.medicineD4.isChecked
            medicineTags[12] = binding.medicineD5.isChecked
            medicineTags[13] = binding.medicineD6.isChecked
            medicineTags[14] = binding.medicineD7.isChecked
            medicineTags[15] = binding.medicineD8.isChecked

            economyTags[0] = binding.economy1.isChecked
            economyTags[1] = binding.economy2.isChecked
            economyTags[2] = binding.economy3.isChecked
            economyTags[3] = binding.economy4.isChecked
            economyTags[4] = binding.economyD1.isChecked
            economyTags[5] = binding.economyD2.isChecked
            economyTags[6] = binding.economyD3.isChecked
            economyTags[7] = binding.economyD4.isChecked
            economyTags[8] = binding.economyD5.isChecked
            economyTags[9] = binding.economyD6.isChecked
            economyTags[10] = binding.economyD7.isChecked
            economyTags[11] = binding.economyD8.isChecked

            otherTags[0] = binding.other1.isChecked
            otherTags[1] = binding.other2.isChecked
            otherTags[2] = binding.other3.isChecked
            otherTags[3] = binding.other4.isChecked
            otherTags[4] = binding.other5.isChecked
            otherTags[5] = binding.other6.isChecked
            otherTags[6] = binding.other7.isChecked
            otherTags[7] = binding.other8.isChecked

            DataHolder.mathTags = mathTags
            DataHolder.physicsTags = physicsTags
            DataHolder.infoTags = infoTags
            DataHolder.isTags = isTags
            DataHolder.langTags = langTags
            DataHolder.medicineTags = medicineTags
            DataHolder.economyTags = economyTags
            DataHolder.otherTags = otherTags

            println(tagList)
            println(tagList.size)

            var userTags = mutableListOf<Tag>()
            for (i in 0 until mathTags.size) if (mathTags[i]) userTags.add(tagList[prefCountOfSubject[0] + i])
            for (i in 0 until physicsTags.size) if (physicsTags[i]) userTags.add(tagList[prefCountOfSubject[1] + i])
            for (i in 0 until infoTags.size) if (infoTags[i]) userTags.add(tagList[prefCountOfSubject[2] + i])
            for (i in 0 until isTags.size) if (isTags[i]) userTags.add(tagList[prefCountOfSubject[3] + i])
            for (i in 0 until langTags.size) if (langTags[i]) userTags.add(tagList[prefCountOfSubject[4] + i])
            for (i in 0 until medicineTags.size) if (medicineTags[i]) userTags.add(tagList[prefCountOfSubject[5] + i])
            for (i in 0 until economyTags.size) if (economyTags[i]) userTags.add(tagList[prefCountOfSubject[6] + i])
            for (i in 0 until otherTags.size) if (otherTags[i]) userTags.add(tagList[prefCountOfSubject[7] + i])
            DataHolder.userTags = userTags
            println(DataHolder.userTags)

            findNavController().navigate(R.id.action_TagFragment_to_MainFragment)
        }

        binding.buttonExtend.setOnClickListener {
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