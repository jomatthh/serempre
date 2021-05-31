package com.jomatt.serempreapp.domain.model

data class Post(
    val userId: Int,
    val title: String,
    val description: String
)

data class User(
    val name: String,
    val username: String,
    val email: String
)