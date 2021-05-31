package com.jomatt.serempreapp.domain.usecase

import androidx.lifecycle.asLiveData
import com.jomatt.serempreapp.domain.PostFavoriteRepository
import javax.inject.Inject

class GetAllPostLocalUseCase  @Inject constructor(private val repo: PostFavoriteRepository) {
    operator fun invoke() = repo.fetchAllPostsLocal().asLiveData()
}