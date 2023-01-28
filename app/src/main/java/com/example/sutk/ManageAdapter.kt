package com.example.sutk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ManageAdapter(private val names: List<String>) : RecyclerView
.Adapter<ManageAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.label)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_skeleton_manage, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.label.text = names[position]
    }

    override fun getItemCount() = names.size
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