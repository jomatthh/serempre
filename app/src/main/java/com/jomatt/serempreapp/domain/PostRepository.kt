package com.jomatt.serempreapp.domain

import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.domain.model.User
import com.jomatt.serempreapp.vo.OperationResult

interface PostRepository {
    suspend fun getPosts(): OperationResult<List<Post>>
    suspend fun getUserById(id: Int): OperationResult<User>
}