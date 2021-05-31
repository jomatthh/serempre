package com.jomatt.serempreapp.data.repository

import com.jomatt.serempreapp.data.PostFavoriteDataSource
import com.jomatt.serempreapp.data.db.DBPost
import com.jomatt.serempreapp.domain.PostFavoriteRepository
import com.jomatt.serempreapp.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostFavoriteLocalRepository @Inject constructor(private val dataSource: PostFavoriteDataSource) :
    PostFavoriteRepository {
    override suspend fun insertPostFavorite(post: Post) {
        val dbPost = DBPost(
            post.id,
            post.userId,
            post.title,
            post.description,
            post.isFavorite
        )
        dataSource.insertFavorite(dbPost)
    }

    override  fun fetchFavoritePostsLocal(): Flow<List<Post>> {
        return dataSource.fetchFavoritePostsLocal().map {
            it.map { db -> db.toPost() }
        }
    }

    override suspend fun insertAll(posts: List<Post>) {
        val items = posts.map {post->
            DBPost(
                post.id,
                post.userId,
                post.title,
                post.description,
            )
        }
        dataSource.insertAll(items)
    }

    override fun fetchAllPostsLocal(): Flow<List<Post>> {
        return dataSource.fetchAllPostsLocal().map {
            it.map { db -> db.toPost() }
        }
    }
}