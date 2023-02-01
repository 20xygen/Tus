package com.example.sutk.dto.User

import com.example.sutk.dto.Tag.Tag

data class UserTag(
    val id: Int,
    val tag: List<Tag>,
)
