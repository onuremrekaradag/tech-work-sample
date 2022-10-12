package com.kefelon.themovieapp.core.database.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.kefelon.themovieapp.core.database.dao.MovieDao
import com.kefelon.themovieapp.core.model.MovieDetail

@Database(
    entities = [MovieDetail::class],
    version = 1,
    exportSchema = true
)
abstract class MovieRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}