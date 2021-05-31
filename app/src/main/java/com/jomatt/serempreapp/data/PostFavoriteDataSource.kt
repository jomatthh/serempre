package com.jomatt.serempreapp.data

import com.jomatt.serempreapp.data.db.DBPost
import kotlinx.coroutines.flow.Flow

interface PostFavoriteDataSource {
    suspend fun insert(post: DBPost)
    fun fetchPostsLocal(): Flow<List<DBPost>>
}