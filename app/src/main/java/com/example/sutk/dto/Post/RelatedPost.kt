package com.example.sutk.com.example.sutk.dto.Post

data class RelatedPost(
    val postId: Int,
    val derivedPost: List<MainInfoPost>,
    val basedPost: List<MainInfoPost>,
)