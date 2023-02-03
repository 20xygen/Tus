package com.example.sutk.global.project

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.sutk.*
import com.example.sutk.client.Client
import com.example.sutk.global.project.tag.*
import com.example.sutk.dataHolder.DataHolder
import com.example.sutk.dto.Tag.Tag
import com.example.sutk.databinding.FragmentProjectBinding
import com.example.sutk.dto.Post.Post
import com.example.sutk.dto.User.UserLoginParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProjectFragment : Fragment() {

    private var _binding: FragmentProjectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root

    }

    var layoutTags: LinearLayout? = null
    var layoutTeam: LinearLayout? = null
    var screen: String? = null
    var post: Post? = null

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var post = DataHolder.postToScreen.get(DataHolder.postToScreenLast)?.last()
        var textView: TextView? = TextView(DataHolder.context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, textView!!.dpToPx(36f))
        params.setMargins(0, textView!!.dpToPx(5f), 0, textView!!.dpToPx(5f))

        screen = DataHolder.postToScreenLast
        post = DataHolder.postToScreen[DataHolder.postToScreenLast]?.
        get(DataHolder.postToScreen[DataHolder.postToScreenLast]?.size?.minus(1) ?: 0)
        layoutTags = binding.tagsLayout
        layoutTeam = binding.teamLayout
        // var tagList = listOf(Tag("Т. вероятности", "Математика"), Tag("Тригонометрия", "Математика"), Tag("Тригонометрия", "Математика"))
        var tagList = post?.tagList
        println(tagList)
        for (element in tagList!!){
            textView = TextView(DataHolder.context)
            textView.setText("    " + element.title)
            textView.layoutParams = params
            when (element.subject) {
                "Математика" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_math)
                    textView.setTextColor(getResources().getColor(R.color.tag_math))
                }
                "Физика" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_physics)
                    textView.setTextColor(getResources().getColor(R.color.tag_physics))
                }
                "Информатика" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_info)
                    textView.setTextColor(getResources().getColor(R.color.tag_info))
                }
                "ИБ" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_is)
                    textView.setTextColor(getResources().getColor(R.color.tag_is))
                }
                "Лингвистика" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_lang)
                    textView.setTextColor(getResources().getColor(R.color.tag_lang))
                }
                "Медицина" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_medicine)
                    textView.setTextColor(getResources().getColor(R.color.tag_medicine))
                }
                "Экономика" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_economy)
                    textView.setTextColor(getResources().getColor(R.color.tag_economy))
                }
                "Другое" -> {
                    textView.setBackgroundResource(R.drawable.tag_background_other)
                    textView.setTextColor(getResources().getColor(R.color.tag_other))
                }
            }
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
            textView.gravity =  Gravity.CENTER_VERTICAL
            layoutTags!!.addView(textView)
        }

        binding.titleLabel.text = post?.title
        binding.descriptionShort.text = post?.description
        binding.description.text = post?.body
        CoroutineScope(Dispatchers.IO).launch{
            for (i in post?.team ?: listOf()){
                DataHolder.teamId.add(Client.getIdByUserLogin(UserLoginParams(0, i.login, "")))
            }
        }

        DataHolder.teamId
        if (post?.team?.size!! > 0){
            textView = TextView(DataHolder.context)
            textView.setText("    " + post!!.team[0].login)
            textView.layoutParams = params
            textView.setBackgroundResource(R.drawable.user_major_background)
            textView.setTextColor(getResources().getColor(R.color.user_major))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
            textView.gravity =  Gravity.CENTER_VERTICAL
            layoutTeam!!.addView(textView)
        }
        for (i in 1 until post?.team?.size!!){
            textView = TextView(DataHolder.context)
            textView.setText("    " + post!!.team[i].login)
            textView.layoutParams = params
            textView.setBackgroundResource(R.drawable.user_background)
            textView.setTextColor(getResources().getColor(R.color.user))
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
            textView.gravity =  Gravity.CENTER_VERTICAL
            layoutTeam!!.addView(textView)
        }

//        layout = binding.globalLayout
//        layout!!.removeView(binding.layout12)
//        layout!!.removeView(binding.layout34)
//        layout!!.removeView(binding.layout56)
//        layout!!.removeView(binding.layout78)

        //inflateLayout(listOf(Tag("Тригонометрия", "Математика"), Tag("Тригонометрия", "Математика"), Tag("Тригонометрия", "Математика")))

        binding.buttonOk.setOnClickListener {
            when(DataHolder.projectPlaceType) {
                0 -> findNavController().navigate(R.id.action_ProjectFragment_to_FeedFragment)
                1 -> findNavController().navigate(R.id.action_ProjectFragment_to_ManageFragment)
                4 -> findNavController().navigate(R.id.action_ProjectFragment_to_ProfileFragment)
            }
            DataHolder.postToScreen[screen]?.removeLast()
        }
    }

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

        curLayout = LinearLayout(DataHolder.context)
        val fragMan: FragmentManager? = fragmentManager
        val fragTransaction: FragmentTransaction = fragMan!!.beginTransaction()
        when(tagList[tagList.size-1].subject){
            "Математика" ->{
                mathFrag = TagMathSkeletonFragment()
                val frameLayout = DataHolder.context?.let { FrameLayout(it) }
                frameLayout?.tag = tagList.size + 100
                frameLayout?.id =  tagList.size + 100
                curLayout!!.addView(frameLayout)
                mathFrag.setTitle(tagList[tagList.size-1].title)
                fragMan.beginTransaction().replace(tagList.size + 100, mathFrag).commit()
            }
        }

//        for (i in 0 until (tagList.size / 2)){
//            curLayout = LinearLayout(DataHolder.context)
//            val fragMan: FragmentManager? = parentFragmentManager
//            val fragTransaction: FragmentTransaction = fragMan!!.beginTransaction()
//            when(tagList[i*2].subject){
//                "Математика" ->{
//                    mathFrag = TagMathSkeletonFragment()
//                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
//                    frameLayout?.tag = i*2
//                    frameLayout?.id = i*2+100
//                    curLayout!!.addView(frameLayout)
//                    mathFrag.setTitle(tagList[i*2].title)
//                    fragMan.beginTransaction().replace(frameLayout?.id ?: 100, mathFrag).commit()
//                }
//            }
//            when(tagList[i*2+1].subject){
//                "Математика" ->{
//                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
//                    frameLayout?.tag = i*2 + 100
//                    frameLayout?.id = i*2 + 100
//                    curLayout!!.addView(frameLayout)
//                    mathFrag.setTitle(tagList[i*2+1].title)
//                    fragMan.beginTransaction().replace(frameLayout?.id ?: 100, mathFrag).commit()
//                }
//            }
//            layout!!.addView(curLayout)
//        }
//        if (tagList.size % 2 == 1){
//            curLayout = LinearLayout(DataHolder.context)
//            val fragMan: FragmentManager? = fragmentManager
//            val fragTransaction: FragmentTransaction = fragMan!!.beginTransaction()
//            when(tagList[tagList.size-1].subject){
//                "Математика" ->{
//                    mathFrag = TagMathSkeletonFragment()
//                    val frameLayout = DataHolder.context?.let { FrameLayout(it) }
//                    frameLayout?.tag = tagList.size - 1
//                    frameLayout?.id =  tagList.size - 1
//                    curLayout!!.addView(frameLayout)
//                    mathFrag.setTitle(tagList[tagList.size-1].title)
//                    fragMan.beginTransaction().replace(frameLayout!!.id, mathFrag).commit()
//                }
//            }
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}