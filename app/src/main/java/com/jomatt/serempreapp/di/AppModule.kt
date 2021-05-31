package com.jomatt.serempreapp.di

import com.google.gson.GsonBuilder
import com.jomatt.serempreapp.BuildConfig
import com.jomatt.serempreapp.data.remote.api.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton()
    @Provides
    fun provideRetrofit(): WebService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.HOST_SEREMPRE)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WebService::class.java)
    }
}