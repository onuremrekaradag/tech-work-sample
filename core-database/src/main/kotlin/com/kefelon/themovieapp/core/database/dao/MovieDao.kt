package com.kefelon.themovieapp.core.database.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kefelon.themovieapp.core.model.MovieDetail

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_detail")
    fun getAll(): List<MovieDetail>

    @Delete
    fun delete(movieDetail: MovieDetail)

    @Insert
    fun insertMovie(movieDetail: MovieDetail)
}