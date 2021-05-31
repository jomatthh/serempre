package com.jomatt.serempreapp.domain.usecase

import com.jomatt.serempreapp.domain.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repo: PostRepository) {
    suspend operator fun invoke() = repo.getPosts()
}