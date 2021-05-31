package com.jomatt.serempreapp.ui.fragment.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jomatt.serempreapp.domain.usecase.GetPostsUseCase
import com.jomatt.serempreapp.domain.usecase.GetUserByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase,
private val getUserByIdUseCase: GetUserByIdUseCase) :
    ViewModel() {

    val fetchPosts = liveData(Dispatchers.IO) {
        emit(getPostsUseCase())
    }
    fun getUserById(id: Int) = liveData(Dispatchers.IO) {
        emit(getUserByIdUseCase(id))
    }
}