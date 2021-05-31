package com.jomatt.serempreapp.data.db

import com.jomatt.serempreapp.data.PostFavoriteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostFavoriteLocalDataSource @Inject constructor(
    private val dataBase: AppDataBase
) : PostFavoriteDataSource {
    override suspend fun insert(post: DBPost) {
        dataBase.postDAO().insert(post)
    }

    override fun fetchPostsLocal(): Flow<List<DBPost>> {
        return dataBase.postDAO().getPostsLocal()
    }
}