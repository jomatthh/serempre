package com.jomatt.serempreapp.data.repository

import com.jomatt.serempreapp.data.Mapper
import com.jomatt.serempreapp.data.PostDataSource
import com.jomatt.serempreapp.domain.PostRepository
import com.jomatt.serempreapp.domain.model.Post
import com.jomatt.serempreapp.domain.model.User
import com.jomatt.serempreapp.vo.OperationResult
import javax.inject.Inject

class PostRemoteRepository @Inject constructor(private val dataSource: PostDataSource) :
    PostRepository {
    override suspend fun getPosts(): OperationResult<List<Post>> {
        return when (val result = dataSource.getPosts()) {
            is OperationResult.Success -> {
                OperationResult.Success(result.data.map { Mapper.postRemoteToPost(it) })
            }
            is OperationResult.Failure -> {
                OperationResult.Failure(result.exception)
            }
        }
    }

    override suspend fun getUserById(id: Int): OperationResult<User> {
        return when (val result = dataSource.getUserById(id)) {
            is OperationResult.Success -> {
                OperationResult.Success( Mapper.userRemoteToUser(result.data) )
            }
            is OperationResult.Failure -> {
                OperationResult.Failure(result.exception)
            }
        }
    }
}