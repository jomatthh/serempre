package com.jomatt.serempreapp.data.remote.dto

data class PostRemote(
    val userId: Int?,
    val id: Int?,
    val title: String?,
    val body: String?,
)


data class UserRemote(
    val name: String?,
    val username: String?,
    val email: String?
)