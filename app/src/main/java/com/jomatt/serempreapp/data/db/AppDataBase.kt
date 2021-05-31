package com.jomatt.serempreapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [DBPost::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun postDAO(): PostDAO
}