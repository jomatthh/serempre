package com.jomatt.serempreapp.data

import com.jomatt.serempreapp.data.db.DBPost
import kotlinx.coroutines.flow.Flow

interface PostFavoriteDataSource {
    suspend fun insertFavorite(post: DBPost)
    suspend fun insertAll(post: List<DBPost>)
    fun fetchFavoritePostsLocal(): Flow<List<DBPost>>
    fun fetchAllPostsLocal():  Flow<List<DBPost>>
}