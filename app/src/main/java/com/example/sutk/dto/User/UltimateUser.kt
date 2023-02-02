package com.example.sutk.dto.User

import com.example.sutk.dto.Achievement.Achievement
import com.example.sutk.dto.Mark.MarkWithPost
import com.example.sutk.dto.Tag.Tag

data class UltimateUser(
    var id: Int,
    var login: String = "",
    var tg: String = "",
    var description: String = "",
    var imageId: Int = 0,
    var email: String = "", // пока не обязательно
    var name: String = "",
    var achievement: List<Achievement>, // пока не обязательно
    var cityName: String, // пока не обязательно
    var userJob: List<String>, // пока не обязатаельно
    var userMark: List<MarkWithPost>,
    var tag: List<Tag>,
)
