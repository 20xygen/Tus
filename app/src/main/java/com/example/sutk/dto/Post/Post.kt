package com.example.sutk.dto.Post

import com.example.sutk.dto.Tag.Tag
import com.example.sutk.dto.User.User

data class Post(
    val id: Int,
    val title: String,
    val icon: Int,
    val description: String,
    val creatorLogin: String,
    val body: String,
    val team: List<User>,
    val posMark: Int,
    val negMark: Int,
    val tagList: List<Tag>,
    val derivedPosts: List<MainInfoPost> = listOf(),
    val basedPosts: List<MainInfoPost> = listOf(),
)
