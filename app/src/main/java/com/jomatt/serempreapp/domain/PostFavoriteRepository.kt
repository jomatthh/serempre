package com.jomatt.serempreapp.domain

import com.jomatt.serempreapp.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostFavoriteRepository {
    suspend fun insertPostFavorite(post: Post)
    fun fetchPostsLocal(): Flow<List<Post>>
}