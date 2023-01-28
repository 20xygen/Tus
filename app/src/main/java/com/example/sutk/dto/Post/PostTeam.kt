package com.example.sutk.com.example.sutk.dto.Post

import com.example.sutk.com.example.sutk.dto.User.User


data class PostTeam(
    val postId: Int,
    val team: List<User>,
)