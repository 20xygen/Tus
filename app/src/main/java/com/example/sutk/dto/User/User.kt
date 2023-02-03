package com.example.sutk.dto.User

data class User(
    val login: String = "",
    val tg: String = "",
    val description: String = "",
    var imageId: Int = 0,
    val email: String = "",
    val name: String = "",
)
