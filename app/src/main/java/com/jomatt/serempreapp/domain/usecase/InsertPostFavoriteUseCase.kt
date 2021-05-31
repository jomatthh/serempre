package com.jomatt.serempreapp.domain.usecase

import com.jomatt.serempreapp.domain.PostFavoriteRepository
import com.jomatt.serempreapp.domain.model.Post
import javax.inject.Inject

class InsertPostFavoriteUseCase  @Inject constructor(private val repo: PostFavoriteRepository) {
    suspend operator fun invoke(post: Post) = repo.insertPostFavorite(post)
}