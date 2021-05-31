package com.jomatt.serempreapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jomatt.serempreapp.domain.model.Post

@Entity(tableName = "tbl_post")
data class DBPost(
    @PrimaryKey
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String,
    val isFavorite: Boolean = false
) {
    fun toPost(): Post {
        return Post(this.id, this.userId, this.title, this.description, this.isFavorite)
    }
}