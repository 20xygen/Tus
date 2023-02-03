package com.example.sutk

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.sutk.dto.Post.Post

class ProfileAdapter(private val items: MutableList<Post>) : RecyclerView
.Adapter<ProfileAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.label)
        val description: TextView = itemView.findViewById(R.id.description)
        var line1: ImageView = itemView.findViewById(R.id.line1)
        var line2: ImageView = itemView.findViewById(R.id.line2)
        var line3: ImageView = itemView.findViewById(R.id.line3)
        var show: Button = itemView.findViewById(R.id.show)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_skeleton_profile, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.label.text = items[position].title
        println(items[position].title)
        holder.description.text = items[position].description
        holder.show.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                DataHolder.profileFragment?.switchToProject()
                DataHolder.postToScreenLast = "profile"
                DataHolder.postToScreen["profile"]?.addLast(items[holder.adapterPosition])
            }
        })

        var imaginaryTags: MutableMap<String, Int> = mutableMapOf("Математика" to 0,
            "Физика" to 0, "Информатика" to 0,
            "ИБ" to 0, "Лингвистика" to 0,
            "Медицина" to 0, "Экономика" to 0,
            "Другое" to 0)

        for (i in items[position].tagList){
            imaginaryTags.set(i.subject, imaginaryTags.get(i.subject)?.inc() ?: 0)
        }
        var subjects: List<String> = listOf("Математика", "Физика", "Информатика", "ИБ", "Лингвистика", "Медицина", "Экономика", "Другое")
        var topSubjects: MutableList<String> = mutableListOf("", "", "")
        for (i in subjects){
            if (imaginaryTags[i] == 0) continue
            if (topSubjects[0] == "" && imaginaryTags[i]!! > 0) topSubjects[0] = i
            else if (topSubjects[1] == "" && imaginaryTags[i]!! > 0){
                if (imaginaryTags[topSubjects[0]]!! < imaginaryTags[i]!!){
                    topSubjects[1] = topSubjects[0]
                    topSubjects[0] = i
                }
                else topSubjects[1] = i
            }
            else if (topSubjects[2] == "" && imaginaryTags[i]!! > 0){
                if (imaginaryTags[topSubjects[0]]!! < imaginaryTags[i]!!){
                    topSubjects[2] = topSubjects[1]
                    topSubjects[1] = topSubjects[0]
                    topSubjects[0] = i
                }
                else if (imaginaryTags[topSubjects[1]]!! < imaginaryTags[i]!!){
                    topSubjects[2] = topSubjects[1]
                    topSubjects[1] = i
                }
                else topSubjects[2] = i
            }
            else{
                if (imaginaryTags[topSubjects[0]]!! < imaginaryTags[i]!!){
                    topSubjects[2] = topSubjects[1]
                    topSubjects[1] = topSubjects[0]
                    topSubjects[0] = i
                }
                else if (imaginaryTags[topSubjects[1]]!! < imaginaryTags[i]!!){
                    topSubjects[2] = topSubjects[1]
                    topSubjects[1] = i
                }
                else if (imaginaryTags[topSubjects[2]]!! < imaginaryTags[i]!!){
                    topSubjects[2] = i
                }
            }
        }
        var subject1 = ""
        var subject2 = ""
        var subject3 = ""
        if (topSubjects[2] != ""){
            subject3 = topSubjects[2]
            subject2 = topSubjects[1]
            subject1 = topSubjects[0]
        }
        else if (topSubjects[1] != ""){
            subject3 = topSubjects[0]
            subject2 = topSubjects[1]
            subject1 = topSubjects[0]
        }
        else {
            subject3 = topSubjects[0]
            subject2 = topSubjects[0]
            subject1 = topSubjects[0]
        }

        when (subject1){
            "Математика" -> holder.line1.setImageResource(R.drawable.line_left_math)
            "Физика" -> holder.line1.setImageResource(R.drawable.line_left_physics)
            "Информатика" -> holder.line1.setImageResource(R.drawable.line_left_info)
            "ИБ" -> holder.line1.setImageResource(R.drawable.line_left_is)
            "Лингвистика" -> holder.line1.setImageResource(R.drawable.line_left_lang)
            "Медицина" -> holder.line1.setImageResource(R.drawable.line_left_medicine)
            "Экономика" -> holder.line1.setImageResource(R.drawable.line_left_economy)
            "Другое" -> holder.line1.setImageResource(R.drawable.line_left_other)
        }
        when (subject2){
            "Математика" -> holder.line2.setImageResource(R.drawable.line_mid_math)
            "Физика" -> holder.line2.setImageResource(R.drawable.line_mid_physics)
            "Информатика" -> holder.line2.setImageResource(R.drawable.line_mid_info)
            "ИБ" -> holder.line2.setImageResource(R.drawable.line_mid_is)
            "Лингвистика" -> holder.line2.setImageResource(R.drawable.line_mid_lang)
            "Медицина" -> holder.line2.setImageResource(R.drawable.line_mid_medicine)
            "Экономика" -> holder.line2.setImageResource(R.drawable.line_mid_economy)
            "Другое" -> holder.line2.setImageResource(R.drawable.line_mid_other)
        }
        when (subject3){
            "Математика" -> holder.line3.setImageResource(R.drawable.line_right_math)
            "Физика" -> holder.line3.setImageResource(R.drawable.line_right_physics)
            "Информатика" -> holder.line3.setImageResource(R.drawable.line_right_info)
            "ИБ" -> holder.line3.setImageResource(R.drawable.line_right_is)
            "Лингвистика" -> holder.line3.setImageResource(R.drawable.line_right_lang)
            "Медицина" -> holder.line3.setImageResource(R.drawable.line_right_medicine)
            "Экономика" -> holder.line3.setImageResource(R.drawable.line_right_economy)
            "Другое" -> holder.line3.setImageResource(R.drawable.line_right_other)
        }

    }


    fun addItem(item: Post){
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addRange(itemRange: MutableList<Post>){
        items.addAll(itemRange)
        notifyItemRangeInserted(items.size - itemRange.size, itemRange.size)
    }

    override fun getItemCount() = items.size
}

//        val description: TextView = itemView.findViewById(R.id.description)
//        val picture: TextView = itemView.findViewById(R.id.picture)
//        val like: TextView = itemView.findViewById(R.id.like)
//        val dislike: TextView = itemView.findViewById(R.id.dislike)
//        val line: TextView = itemView.findViewById(R.id.line)
//        val line1: TextView = itemView.findViewById(R.id.line1)
//        val line2: TextView = itemView.findViewById(R.id.line2)
//        val line3: TextView = itemView.findViewById(R.id.line3)
//        val bottom: TextView = itemView.findViewById(R.id.bottom)
//        val back_icon: TextView = itemView.findViewById(R.id.back_icon)