package com.example.sutk.dto.Post

import com.example.sutk.dto.Tag.Tag

data class PostTag(
    val postId: Int,
    val tagList: List<Tag>,
)
