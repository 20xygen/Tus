package com.example.sutk.dto.User

import com.example.sutk.dto.Mark.MarkWithPost

data class UserMark(
    val id: Int,
    val userMark: List<MarkWithPost>,
)
