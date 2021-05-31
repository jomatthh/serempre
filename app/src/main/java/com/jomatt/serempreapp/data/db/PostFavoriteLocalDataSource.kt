package com.jomatt.serempreapp.data.db

import com.jomatt.serempreapp.data.PostFavoriteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostFavoriteLocalDataSource @Inject constructor(
    private val dataBase: AppDataBase
) : PostFavoriteDataSource {
    override suspend fun insertFavorite(post: DBPost) {
        dataBase.postDAO().insertFavorite(post)
    }

    override fun fetchFavoritePostsLocal(): Flow<List<DBPost>> {
        return dataBase.postDAO().getFavoritePostsLocal()
    }

    override suspend fun insertAll(post: List<DBPost>) {
        dataBase.postDAO().insertAll(post)
    }

    override fun fetchAllPostsLocal(): Flow<List<DBPost>> {
        return dataBase.postDAO().getAllPostLocal()
    }
}