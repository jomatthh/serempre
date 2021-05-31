package com.jomatt.serempreapp.di

import com.jomatt.serempreapp.data.PostDataSource
import com.jomatt.serempreapp.data.remote.PostRemoteDataSource
import com.jomatt.serempreapp.data.repository.PostRemoteRepository
import com.jomatt.serempreapp.domain.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {

    @Singleton
    @Binds
    abstract fun bindPostRemoteDataSource(dataSource: PostRemoteDataSource): PostDataSource

    @Singleton
    @Binds
    abstract fun bindPostRemoteRepository(repo: PostRemoteRepository): PostRepository

}