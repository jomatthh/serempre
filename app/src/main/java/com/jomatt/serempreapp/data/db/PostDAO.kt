package com.jomatt.serempreapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: DBPost)

    @Query("SELECT * FROM TBL_POST")
    fun getPostsLocal(): Flow<List<DBPost>>
}