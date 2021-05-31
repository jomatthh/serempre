package com.jomatt.serempreapp.data.remote.api

import com.jomatt.serempreapp.data.remote.dto.PostRemote
import com.jomatt.serempreapp.data.remote.dto.UserRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("posts")
    suspend fun getPosts() : Response<List<PostRemote>>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): Response<UserRemote>
}