package com.jomatt.serempreapp.data

import com.jomatt.serempreapp.data.remote.dto.PostRemote
import com.jomatt.serempreapp.data.remote.dto.UserRemote
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.domain.model.User

object Mapper {
    fun postRemoteToPost(data: PostRemote): Post {
        return Post(data.id ?: 0, data.userId ?: 0, data.title ?: "", data.body ?: "",false)
    }

    fun userRemoteToUser(data: UserRemote): User {
        return User(data.name ?: "", data.username ?: "", data.email ?: "")
    }
}