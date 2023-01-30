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
import com.example.sutk.com.example.sutk.dto.Post.Post

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
                DataHolder.feedFragment?.switchToProject()
            }
        })

        when (items[position].tagList[0]){
            "0" -> holder.line1.setImageResource(R.drawable.line_left_math)
            "1" -> holder.line1.setImageResource(R.drawable.line_left_physics)
            "2" -> holder.line1.setImageResource(R.drawable.line_left_info)
            "3" -> holder.line1.setImageResource(R.drawable.line_left_is)
            "4" -> holder.line1.setImageResource(R.drawable.line_left_lang)
            "5" -> holder.line1.setImageResource(R.drawable.line_left_medicine)
            "6" -> holder.line1.setImageResource(R.drawable.line_left_economy)
            "7" -> holder.line1.setImageResource(R.drawable.line_left_other)
        }
        when (items[position].tagList[1]){
            "0" -> holder.line2.setImageResource(R.drawable.line_mid_math)
            "1" -> holder.line2.setImageResource(R.drawable.line_mid_physics)
            "2" -> holder.line2.setImageResource(R.drawable.line_mid_info)
            "3" -> holder.line2.setImageResource(R.drawable.line_mid_is)
            "4" -> holder.line2.setImageResource(R.drawable.line_mid_lang)
            "5" -> holder.line2.setImageResource(R.drawable.line_mid_medicine)
            "6" -> holder.line2.setImageResource(R.drawable.line_mid_economy)
            "7" -> holder.line2.setImageResource(R.drawable.line_mid_other)
        }
        when (items[position].tagList[2]){
            "0" -> holder.line3.setImageResource(R.drawable.line_right_math)
            "1" -> holder.line3.setImageResource(R.drawable.line_right_physics)
            "2" -> holder.line3.setImageResource(R.drawable.line_right_info)
            "3" -> holder.line3.setImageResource(R.drawable.line_right_is)
            "4" -> holder.line3.setImageResource(R.drawable.line_right_lang)
            "5" -> holder.line3.setImageResource(R.drawable.line_right_medicine)
            "6" -> holder.line3.setImageResource(R.drawable.line_right_economy)
            "7" -> holder.line3.setImageResource(R.drawable.line_right_other)
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