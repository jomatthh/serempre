package com.jomatt.serempreapp.domain.usecase

import com.jomatt.serempreapp.domain.PostFavoriteRepository
import com.jomatt.serempreapp.domain.PostRepository
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.vo.OperationResult
import javax.inject.Inject

class SyncPostsUseCase @Inject constructor(
    private val repo: PostRepository,
    private val repoFavorite: PostFavoriteRepository
) {
    suspend operator fun invoke() {
        val result = repo.getPosts()
        if (result is OperationResult.Success) {
            repoFavorite.insertAll(result.data)
        }
    }
}