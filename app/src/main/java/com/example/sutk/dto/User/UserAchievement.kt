package com.example.sutk.dto.User

import com.example.sutk.dto.Achievement.Achievement

data class UserAchievement(
    val userId: Int,
    val achievement: List<Achievement>,
)
