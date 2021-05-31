package com.jomatt.serempreapp.data

import com.jomatt.serempreapp.data.remote.dto.PostRemote
import com.jomatt.serempreapp.data.remote.dto.UserRemote
import com.jomatt.serempreapp.vo.OperationResult

interface PostDataSource {
    suspend fun getPosts(): OperationResult<List<PostRemote>>
    suspend fun getUserById(id: Int): OperationResult< UserRemote >
}