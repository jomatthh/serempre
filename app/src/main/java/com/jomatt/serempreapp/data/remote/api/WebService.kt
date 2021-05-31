package com.jomatt.serempreapp.data.remote.api

import com.jomatt.serempreapp.data.remote.dto.PostRemote
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("posts")
    suspend fun getPosts() : Response<List<PostRemote>>
}