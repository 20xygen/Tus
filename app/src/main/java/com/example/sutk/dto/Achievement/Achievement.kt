package com.example.sutk.dto.Achievement

import com.example.sutk.dto.Tag.Tag

data class Achievement(
    val achievementTitle: String,
    val achievementType: String,
    val achievementTag: Tag,
)
