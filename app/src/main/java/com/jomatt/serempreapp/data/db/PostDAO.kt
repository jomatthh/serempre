package com.jomatt.serempreapp.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PostDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertFavorite(post: DBPost)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(list: List<DBPost>)

    @Query("SELECT * FROM TBL_POST")
    abstract fun getAllPostLocal(): Flow<List<DBPost>>

    @Query("SELECT * FROM TBL_POST WHERE isFavorite = 1")
    abstract fun getFavoritePostsLocal(): Flow<List<DBPost>>

    @Transaction
    open suspend fun syncPosts(listParameters: List<DBPost>) {
        deleteAll()
        insertAll(listParameters)
    }

    @Query("DELETE FROM tbl_post")
    abstract suspend fun deleteAll()
}