package com.jomatt.serempreapp.ui.fragment.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val syncPostsUseCase: SyncPostsUseCase,
    private val getAllPostLocalUseCase: GetAllPostLocalUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val insertPostFavoriteUseCase: InsertPostFavoriteUseCase,
    private val getPostFavoritesLocalUseCase: GetPostFavoritesLocalUseCase
) :
    ViewModel() {

    fun syncData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                syncPostsUseCase()
            }
        }
    }

    fun getUserById(id: Int) = liveData(Dispatchers.IO) {
        emit(getUserByIdUseCase(id))
    }

    fun insertFavorite(post: Post) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                insertPostFavoriteUseCase(post)
            }
        }
    }

    val fetchFavoritePostLocal = getPostFavoritesLocalUseCase()
    val fetchAllPostLocal = getAllPostLocalUseCase()
}