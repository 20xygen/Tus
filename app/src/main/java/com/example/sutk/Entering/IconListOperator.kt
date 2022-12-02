package com.example.sutk.Entering

import android.widget.ImageButton
import android.widget.ImageView
import com.example.sutk.R
import com.example.sutk.databinding.FragmentSelectingProfileIconBinding

class IconListOperator {
    private var button_array = arrayOfNulls<ImageButton>(21)
    private var view_array = arrayOfNulls<ImageView>(21)
    private lateinit var binding: FragmentSelectingProfileIconBinding
    private var chosen = -1

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

        this.binding = binding
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
}