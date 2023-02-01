package com.example.sutk.dto.Post

import com.example.sutk.dto.Post.MainInfoPost

data class RelatedPost(
    val postId: Int,
    val derivedPost: List<MainInfoPost>,
    val basedPost: List<MainInfoPost>,
)
