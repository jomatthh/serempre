package com.jomatt.serempreapp.data.remote

import com.jomatt.serempreapp.data.PostDataSource
import com.jomatt.serempreapp.data.remote.api.WebService
import com.jomatt.serempreapp.data.remote.dto.PostRemote
import com.jomatt.serempreapp.data.remote.dto.UserRemote
import com.jomatt.serempreapp.vo.OperationResult
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(private val webService: WebService) :
    PostDataSource {
    override suspend fun getPosts(): OperationResult<List<PostRemote>> {
        return try {
            val response = webService.getPosts()
            val data = response.body()
            if (response.isSuccessful && data != null) {
                OperationResult.Success(data)
            } else {
                OperationResult.Failure(Exception(response.errorBody()?.toString()))
            }
        } catch (e: Exception) {
            OperationResult.Failure(e)
        }
    }

    override suspend fun getUserById(id: Int): OperationResult<UserRemote> {
        return try {
            val response = webService.getUserById(id)
            val data = response.body()
            if (response.isSuccessful && data != null) {
                OperationResult.Success(data)
            } else {
                OperationResult.Failure(Exception(response.errorBody()?.toString()))
            }
        } catch (e: Exception) {
            OperationResult.Failure(e)
        }
    }
}