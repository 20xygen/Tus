package com.example.sutk.Entering

import android.widget.ImageButton
import android.widget.ImageView
import com.example.sutk.R
import com.example.sutk.databinding.FragmentSelectingPostIconBinding
import com.example.sutk.databinding.FragmentSelectingProfileIconBinding

class IconListOperator {
    companion object {
        private var button_array = arrayOfNulls<ImageButton>(21)
        private var view_array = arrayOfNulls<ImageView>(21)
        private lateinit var binding: FragmentSelectingProfileIconBinding
        var chosen = -1

        private var post_button_array = arrayOfNulls<ImageButton>(63)
        private var post_view_array = arrayOfNulls<ImageView>(63)
        private lateinit var post_binding: FragmentSelectingPostIconBinding
        var post_chosen = -1
    }

    public fun init(binding: FragmentSelectingProfileIconBinding) {
        button_array[0] = binding.button1.imageButton
        button_array[1] = binding.button2.imageButton
        button_array[2] = binding.button3.imageButton
        button_array[3] = binding.button4.imageButton
        button_array[4] = binding.button5.imageButton
        button_array[5] = binding.button6.imageButton
        button_array[6] = binding.button7.imageButton
        button_array[7] = binding.button8.imageButton
        button_array[8] = binding.button9.imageButton
        button_array[9] = binding.button10.imageButton
        button_array[10] = binding.button11.imageButton
        button_array[11] = binding.button12.imageButton
        button_array[12] = binding.button13.imageButton
        button_array[13] = binding.button14.imageButton
        button_array[14] = binding.button15.imageButton
        button_array[15] = binding.button16.imageButton
        button_array[16] = binding.button17.imageButton
        button_array[17] = binding.button18.imageButton
        button_array[18] = binding.button19.imageButton
        button_array[19] = binding.button20.imageButton
        button_array[20] = binding.button21.imageButton

        view_array[0] = binding.button1.imageView
        view_array[1] = binding.button2.imageView
        view_array[2] = binding.button3.imageView
        view_array[3] = binding.button4.imageView
        view_array[4] = binding.button5.imageView
        view_array[5] = binding.button6.imageView
        view_array[6] = binding.button7.imageView
        view_array[7] = binding.button8.imageView
        view_array[8] = binding.button9.imageView
        view_array[9] = binding.button10.imageView
        view_array[10] = binding.button11.imageView
        view_array[11] = binding.button12.imageView
        view_array[12] = binding.button13.imageView
        view_array[13] = binding.button14.imageView
        view_array[14] = binding.button15.imageView
        view_array[15] = binding.button16.imageView
        view_array[16] = binding.button17.imageView
        view_array[17] = binding.button18.imageView
        view_array[18] = binding.button19.imageView
        view_array[19] = binding.button20.imageView
        view_array[20] = binding.button21.imageView

        IconListOperator.binding = binding
    }

    public fun setUnique(){
        button_array[0]?.setImageResource(R.drawable.icon_anime)
        button_array[1]?.setImageResource(R.drawable.icon_batman)
        button_array[2]?.setImageResource(R.drawable.icon_chewbacca)
        button_array[3]?.setImageResource(R.drawable.icon_cookie)
        button_array[4]?.setImageResource(R.drawable.icon_dog)
        button_array[5]?.setImageResource(R.drawable.icon_futurama)
        button_array[6]?.setImageResource(R.drawable.icon_groot)
        button_array[7]?.setImageResource(R.drawable.icon_gunter)
        button_array[8]?.setImageResource(R.drawable.icon_homer)
        button_array[9]?.setImageResource(R.drawable.icon_jetpack)
        button_array[10]?.setImageResource(R.drawable.icon_naruto)
        button_array[11]?.setImageResource(R.drawable.icon_neo)
        button_array[12]?.setImageResource(R.drawable.icon_robber)
        button_array[13]?.setImageResource(R.drawable.icon_smurf)
        button_array[14]?.setImageResource(R.drawable.icon_sonic)
        button_array[15]?.setImageResource(R.drawable.icon_spongebob)
        button_array[16]?.setImageResource(R.drawable.icon_stich)
        button_array[17]?.setImageResource(R.drawable.icon_tom)
        button_array[18]?.setImageResource(R.drawable.icon_woody)
        button_array[19]?.setImageResource(R.drawable.icon_yellow)
        button_array[20]?.setImageResource(R.drawable.icon_yoda)
    }

    public fun getChosen() :Int{
        return chosen
    }

    public fun setListener(){
        for(i in 0..20){
            button_array[i]?.setOnClickListener {
                if (chosen != i || chosen == -1){
                    view_array[i]?.setImageResource(R.drawable.plate_selected)
                    if (chosen != -1) view_array[chosen]?.setImageResource(R.drawable.plate_simple)
                    chosen = i
                }
                else {
                    view_array[i]?.setImageResource(R.drawable.plate_simple)
                    chosen = -1
                }
            }
        }
    }

    public fun postInit(post_binding: FragmentSelectingPostIconBinding) {
        post_button_array[0] = post_binding.button1.imageButton
        post_button_array[1] = post_binding.button2.imageButton
        post_button_array[2] = post_binding.button3.imageButton
        post_button_array[3] = post_binding.button4.imageButton
        post_button_array[4] = post_binding.button5.imageButton
        post_button_array[5] = post_binding.button6.imageButton
        post_button_array[6] = post_binding.button7.imageButton
        post_button_array[7] = post_binding.button8.imageButton
        post_button_array[8] = post_binding.button9.imageButton
        post_button_array[9] = post_binding.button10.imageButton
        post_button_array[10] = post_binding.button11.imageButton
        post_button_array[11] = post_binding.button12.imageButton
        post_button_array[12] = post_binding.button13.imageButton
        post_button_array[13] = post_binding.button14.imageButton
        post_button_array[14] = post_binding.button15.imageButton
        post_button_array[15] = post_binding.button16.imageButton
        post_button_array[16] = post_binding.button17.imageButton
        post_button_array[17] = post_binding.button18.imageButton
        post_button_array[18] = post_binding.button19.imageButton
        post_button_array[19] = post_binding.button20.imageButton
        post_button_array[20] = post_binding.button21.imageButton
        post_button_array[21] = post_binding.button22.imageButton
        post_button_array[22] = post_binding.button23.imageButton
        post_button_array[23] = post_binding.button24.imageButton
        post_button_array[24] = post_binding.button25.imageButton
        post_button_array[25] = post_binding.button26.imageButton
        post_button_array[26] = post_binding.button27.imageButton
        post_button_array[27] = post_binding.button28.imageButton
        post_button_array[28] = post_binding.button29.imageButton
        post_button_array[29] = post_binding.button30.imageButton
        post_button_array[30] = post_binding.button31.imageButton
        post_button_array[31] = post_binding.button32.imageButton
        post_button_array[32] = post_binding.button33.imageButton
        post_button_array[33] = post_binding.button34.imageButton
        post_button_array[34] = post_binding.button35.imageButton
        post_button_array[35] = post_binding.button36.imageButton
        post_button_array[36] = post_binding.button37.imageButton
        post_button_array[37] = post_binding.button38.imageButton
        post_button_array[38] = post_binding.button39.imageButton
        post_button_array[39] = post_binding.button40.imageButton
        post_button_array[40] = post_binding.button41.imageButton
        post_button_array[41] = post_binding.button42.imageButton
        post_button_array[42] = post_binding.button43.imageButton
        post_button_array[43] = post_binding.button44.imageButton
        post_button_array[44] = post_binding.button45.imageButton
        post_button_array[45] = post_binding.button46.imageButton
        post_button_array[46] = post_binding.button47.imageButton
        post_button_array[47] = post_binding.button48.imageButton
        post_button_array[48] = post_binding.button49.imageButton
        post_button_array[49] = post_binding.button50.imageButton
        post_button_array[50] = post_binding.button51.imageButton
        post_button_array[51] = post_binding.button52.imageButton
        post_button_array[52] = post_binding.button53.imageButton
        post_button_array[53] = post_binding.button54.imageButton
        post_button_array[54] = post_binding.button55.imageButton
        post_button_array[55] = post_binding.button56.imageButton
        post_button_array[56] = post_binding.button57.imageButton
        post_button_array[57] = post_binding.button58.imageButton
        post_button_array[58] = post_binding.button59.imageButton
        post_button_array[59] = post_binding.button60.imageButton
        post_button_array[60] = post_binding.button61.imageButton
        post_button_array[61] = post_binding.button62.imageButton
        post_button_array[62] = post_binding.button63.imageButton

        post_view_array[0] = post_binding.button1.imageView
        post_view_array[1] = post_binding.button2.imageView
        post_view_array[2] = post_binding.button3.imageView
        post_view_array[3] = post_binding.button4.imageView
        post_view_array[4] = post_binding.button5.imageView
        post_view_array[5] = post_binding.button6.imageView
        post_view_array[6] = post_binding.button7.imageView
        post_view_array[7] = post_binding.button8.imageView
        post_view_array[8] = post_binding.button9.imageView
        post_view_array[9] = post_binding.button10.imageView
        post_view_array[10] = post_binding.button11.imageView
        post_view_array[11] = post_binding.button12.imageView
        post_view_array[12] = post_binding.button13.imageView
        post_view_array[13] = post_binding.button14.imageView
        post_view_array[14] = post_binding.button15.imageView
        post_view_array[15] = post_binding.button16.imageView
        post_view_array[16] = post_binding.button17.imageView
        post_view_array[17] = post_binding.button18.imageView
        post_view_array[18] = post_binding.button19.imageView
        post_view_array[19] = post_binding.button20.imageView
        post_view_array[20] = post_binding.button21.imageView
        post_view_array[21] = post_binding.button22.imageView
        post_view_array[22] = post_binding.button23.imageView
        post_view_array[23] = post_binding.button24.imageView
        post_view_array[24] = post_binding.button25.imageView
        post_view_array[25] = post_binding.button26.imageView
        post_view_array[26] = post_binding.button27.imageView
        post_view_array[27] = post_binding.button28.imageView
        post_view_array[28] = post_binding.button29.imageView
        post_view_array[29] = post_binding.button30.imageView
        post_view_array[30] = post_binding.button31.imageView
        post_view_array[31] = post_binding.button32.imageView
        post_view_array[32] = post_binding.button33.imageView
        post_view_array[33] = post_binding.button34.imageView
        post_view_array[34] = post_binding.button35.imageView
        post_view_array[35] = post_binding.button36.imageView
        post_view_array[36] = post_binding.button37.imageView
        post_view_array[37] = post_binding.button38.imageView
        post_view_array[38] = post_binding.button39.imageView
        post_view_array[39] = post_binding.button40.imageView
        post_view_array[40] = post_binding.button41.imageView
        post_view_array[41] = post_binding.button42.imageView
        post_view_array[42] = post_binding.button43.imageView
        post_view_array[43] = post_binding.button44.imageView
        post_view_array[44] = post_binding.button45.imageView
        post_view_array[45] = post_binding.button46.imageView
        post_view_array[46] = post_binding.button47.imageView
        post_view_array[47] = post_binding.button48.imageView
        post_view_array[48] = post_binding.button49.imageView
        post_view_array[49] = post_binding.button50.imageView
        post_view_array[50] = post_binding.button51.imageView
        post_view_array[51] = post_binding.button52.imageView
        post_view_array[52] = post_binding.button53.imageView
        post_view_array[53] = post_binding.button54.imageView
        post_view_array[54] = post_binding.button55.imageView
        post_view_array[55] = post_binding.button56.imageView
        post_view_array[56] = post_binding.button57.imageView
        post_view_array[57] = post_binding.button58.imageView
        post_view_array[58] = post_binding.button59.imageView
        post_view_array[59] = post_binding.button60.imageView
        post_view_array[60] = post_binding.button61.imageView
        post_view_array[61] = post_binding.button62.imageView
        post_view_array[62] = post_binding.button63.imageView

        IconListOperator.post_binding = post_binding
    }

    public fun postSetUnique(){
        post_button_array[0]?.setImageResource(R.drawable.ip__1_)
        post_button_array[1]?.setImageResource(R.drawable.ip__2_)
        post_button_array[2]?.setImageResource(R.drawable.ip__3_)
        post_button_array[3]?.setImageResource(R.drawable.ip__4_)
        post_button_array[4]?.setImageResource(R.drawable.ip__5_)
        post_button_array[5]?.setImageResource(R.drawable.ip__6_)
        post_button_array[6]?.setImageResource(R.drawable.ip__7_)
        post_button_array[7]?.setImageResource(R.drawable.ip__8_)
        post_button_array[8]?.setImageResource(R.drawable.ip__9_)
        post_button_array[9]?.setImageResource(R.drawable.ip__10_)
        post_button_array[10]?.setImageResource(R.drawable.ip__11_)
        post_button_array[11]?.setImageResource(R.drawable.ip__12_)
        post_button_array[12]?.setImageResource(R.drawable.ip__13_)
        post_button_array[13]?.setImageResource(R.drawable.ip__14_)
        post_button_array[14]?.setImageResource(R.drawable.ip__15_)
        post_button_array[15]?.setImageResource(R.drawable.ip__16_)
        post_button_array[16]?.setImageResource(R.drawable.ip__17_)
        post_button_array[17]?.setImageResource(R.drawable.ip__18_)
        post_button_array[18]?.setImageResource(R.drawable.ip__19_)
        post_button_array[19]?.setImageResource(R.drawable.ip__20_)
        post_button_array[20]?.setImageResource(R.drawable.ip__21_)
        post_button_array[21]?.setImageResource(R.drawable.ip__22_)
        post_button_array[22]?.setImageResource(R.drawable.ip__23_)
        post_button_array[23]?.setImageResource(R.drawable.ip__24_)
        post_button_array[24]?.setImageResource(R.drawable.ip__25_)
        post_button_array[25]?.setImageResource(R.drawable.ip__26_)
        post_button_array[26]?.setImageResource(R.drawable.ip__27_)
        post_button_array[27]?.setImageResource(R.drawable.ip__28_)
        post_button_array[28]?.setImageResource(R.drawable.ip__29_)
        post_button_array[29]?.setImageResource(R.drawable.ip__30_)
        post_button_array[30]?.setImageResource(R.drawable.ip__31_)
        post_button_array[31]?.setImageResource(R.drawable.ip__32_)
        post_button_array[32]?.setImageResource(R.drawable.ip__33_)
        post_button_array[33]?.setImageResource(R.drawable.ip__34_)
        post_button_array[34]?.setImageResource(R.drawable.ip__35_)
        post_button_array[35]?.setImageResource(R.drawable.ip__36_)
        post_button_array[36]?.setImageResource(R.drawable.ip__37_)
        post_button_array[37]?.setImageResource(R.drawable.ip__38_)
        post_button_array[38]?.setImageResource(R.drawable.ip__39_)
        post_button_array[39]?.setImageResource(R.drawable.ip__40_)
        post_button_array[40]?.setImageResource(R.drawable.ip__41_)
        post_button_array[41]?.setImageResource(R.drawable.ip__42_)
        post_button_array[42]?.setImageResource(R.drawable.ip__43_)
        post_button_array[43]?.setImageResource(R.drawable.ip__44_)
        post_button_array[44]?.setImageResource(R.drawable.ip__45_)
        post_button_array[45]?.setImageResource(R.drawable.ip__46_)
        post_button_array[46]?.setImageResource(R.drawable.ip__47_)
        post_button_array[47]?.setImageResource(R.drawable.ip__48_)
        post_button_array[48]?.setImageResource(R.drawable.ip__49_)
        post_button_array[49]?.setImageResource(R.drawable.ip__50_)
        post_button_array[50]?.setImageResource(R.drawable.ip__51_)
        post_button_array[51]?.setImageResource(R.drawable.ip__52_)
        post_button_array[52]?.setImageResource(R.drawable.ip__53_)
        post_button_array[53]?.setImageResource(R.drawable.ip__54_)
        post_button_array[54]?.setImageResource(R.drawable.ip__55_)
        post_button_array[55]?.setImageResource(R.drawable.ip__56_)
        post_button_array[56]?.setImageResource(R.drawable.ip__57_)
        post_button_array[57]?.setImageResource(R.drawable.ip__58_)
        post_button_array[58]?.setImageResource(R.drawable.ip__59_)
        post_button_array[59]?.setImageResource(R.drawable.ip__60_)
        post_button_array[60]?.setImageResource(R.drawable.ip__61_)
        post_button_array[61]?.setImageResource(R.drawable.ip__62_)
        post_button_array[62]?.setImageResource(R.drawable.ip__63_)
    }

    public fun postGetChosen() :Int{
        return post_chosen
    }

    public fun postSetListener(){
        for(i in 0..20){
            post_button_array[i]?.setOnClickListener {
                if (post_chosen != i || post_chosen == -1){
                    post_view_array[i]?.setImageResource(R.drawable.plate_selected)
                    if (post_chosen != -1) post_view_array[post_chosen]?.setImageResource(R.drawable.plate_simple)
                    post_chosen = i
                }
                else {
                    post_view_array[i]?.setImageResource(R.drawable.plate_simple)
                    post_chosen = -1
                }
            }
        }
    }
}