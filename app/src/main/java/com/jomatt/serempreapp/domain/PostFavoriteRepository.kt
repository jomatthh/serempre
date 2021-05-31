package com.jomatt.serempreapp.domain

import com.jomatt.serempreapp.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostFavoriteRepository {
    suspend fun insertPostFavorite(post: Post)
    suspend fun insertAll(posts: List<Post>)
    fun fetchFavoritePostsLocal(): Flow<List<Post>>
    fun fetchAllPostsLocal(): Flow<List<Post>>
}