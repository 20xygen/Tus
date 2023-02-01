package com.example.sutk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.sutk.databinding.FragmentTagHolderBinding
import com.example.sutk.dto.Tag.Tag


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TagHolderFragment : Fragment() {

    private var _binding: FragmentTagHolderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTagHolderBinding.inflate(inflater, container, false)
        return binding.root

    }

    var layout: LinearLayout? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout = binding.globalLayout
        layout!!.removeView(binding.layout12)
        layout!!.removeView(binding.layout34)
        layout!!.removeView(binding.layout56)
        layout!!.removeView(binding.layout78)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

//    <include layout="@layout/tag_math_skeleton"
//    android:id="@+id/tag_1"
//    android:layout_marginTop="5dp"
//    android:layout_marginEnd="5dp"
//    android:layout_marginBottom="5dp"
//    android:layout_marginStart="0dp"
//    android:layout_weight="1"
//    android:layout_width="0dp"
//    android:layout_height="wrap_content" />

    var listOfLayout: MutableList<LinearLayout?>? = null
    fun inflateLayout(tagList: List<Tag>){
        var curLayout: LinearLayout? = null

        var mathFrag: TagMathSkeletonFragment = TagMathSkeletonFragment()
        var physicsFrag: TagPhysicsSkeletonFragment = TagPhysicsSkeletonFragment()
        var infoFrag: TagInfoSkeletonFragment = TagInfoSkeletonFragment()
        var isFrag: TagIsSkeletonFragment = TagIsSkeletonFragment()
        var langFrag: TagLangSkeletonFragment = TagLangSkeletonFragment()
        var medicineFrag: TagMedicineSkeletonFragment = TagMedicineSkeletonFragment()
        var economyFrag: TagEconomySkeletonFragment = TagEconomySkeletonFragment()
        var otherFrag: TagOtherSkeletonFragment = TagOtherSkeletonFragment()

        for (i in 0 .. (tagList.size / 2)){
            curLayout = LinearLayout(DataHolder.context)
            val fragMan: FragmentManager? = fragmentManager
            val fragTransaction: FragmentTransaction = fragMan!!.beginTransaction()
            when(tagList[i*2].subject){
                "Математика" ->{
                    mathFrag = TagMathSkeletonFragment()
                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
                    frameLayout?.tag = i*2
                    curLayout!!.addView(frameLayout)
                    mathFrag.setTitle(tagList[i*2].title)
                    fragMan.beginTransaction().replace(frameLayout!!.id, mathFrag).commit()
                }
            }
            when(tagList[i*2+1].subject){
                "Математика" ->{
                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
                    frameLayout?.tag = i*2 + 1
                    curLayout!!.addView(frameLayout)
                    mathFrag.setTitle(tagList[i*2+1].title)
                    fragMan.beginTransaction().replace(frameLayout!!.id, mathFrag).commit()
                }
            }
            layout!!.addView(curLayout)
        }
        if (tagList.size % 2 == 1){
            curLayout = LinearLayout(DataHolder.context)
            val fragMan: FragmentManager? = fragmentManager
            val fragTransaction: FragmentTransaction = fragMan!!.beginTransaction()
            when(tagList[tagList.size-1].subject){
                "Математика" ->{
                    mathFrag = TagMathSkeletonFragment()
                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
                    frameLayout?.tag = tagList.size - 1
                    curLayout!!.addView(frameLayout)
                    mathFrag.setTitle(tagList[tagList.size-1].title)
                    fragMan.beginTransaction().replace(frameLayout!!.id, mathFrag).commit()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}