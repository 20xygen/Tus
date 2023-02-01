package com.example.sutk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sutk.Entering.IconListOperator
import com.example.sutk.dto.Post.Post

class PostAdapter(private val items: MutableList<Post>) : RecyclerView
.Adapter<PostAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.label)
        val like: ImageView = itemView.findViewById(R.id.like)
        val dislike: ImageView = itemView.findViewById(R.id.dislike)
        val description: TextView = itemView.findViewById(R.id.description)
        val show: Button = itemView.findViewById(R.id.show)
        var line1: ImageView = itemView.findViewById(R.id.line1)
        var line2: ImageView = itemView.findViewById(R.id.line2)
        var line3: ImageView = itemView.findViewById(R.id.line3)
        var icon: ImageView = itemView.findViewById(R.id.picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_skeleton, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.label.text = items[position].title
        println(items[position].title)
        holder.description.text = items[position].body
        holder.like.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(DataHolder.context, "Нравится", Toast.LENGTH_SHORT).show()
            }
        })
        holder.dislike.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(DataHolder.context, "Не нравится", Toast.LENGTH_SHORT).show()
            }
        })
        holder.show.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                DataHolder.postToScreenLast = "feed"
                DataHolder.postToScreen["feed"]?.addLast(items[holder.adapterPosition])
                DataHolder.feedFragment?.switchToProject()
            }
        })

        IconListOperator().setPostIcon(holder.icon, items[position].icon)
        println(items[position].icon)

        when (items[position].tagList[0].subject){
            "Математика" -> holder.line1.setImageResource(R.drawable.line_left_math)
            "Физика" -> holder.line1.setImageResource(R.drawable.line_left_physics)
            "Информатика" -> holder.line1.setImageResource(R.drawable.line_left_info)
            "ИБ" -> holder.line1.setImageResource(R.drawable.line_left_is)
            "Лингвистика" -> holder.line1.setImageResource(R.drawable.line_left_lang)
            "Медицина" -> holder.line1.setImageResource(R.drawable.line_left_medicine)
            "Экономика" -> holder.line1.setImageResource(R.drawable.line_left_economy)
            "Другое" -> holder.line1.setImageResource(R.drawable.line_left_other)
        }
        when (items[position].tagList[1].subject){
            "Математика" -> holder.line2.setImageResource(R.drawable.line_mid_math)
            "Физика" -> holder.line2.setImageResource(R.drawable.line_mid_physics)
            "Информатика" -> holder.line2.setImageResource(R.drawable.line_mid_info)
            "ИБ" -> holder.line2.setImageResource(R.drawable.line_mid_is)
            "Лингвистика" -> holder.line2.setImageResource(R.drawable.line_mid_lang)
            "Медицина" -> holder.line2.setImageResource(R.drawable.line_mid_medicine)
            "Экономика" -> holder.line2.setImageResource(R.drawable.line_mid_economy)
            "Другое" -> holder.line2.setImageResource(R.drawable.line_mid_other)
        }
        when (items[position].tagList[2].subject){
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