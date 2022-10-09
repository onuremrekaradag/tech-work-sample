package com.kefelon.themovieapp.core.data.repository

import com.kefelon.themovieapp.core.model.MovieResponse


interface TMDBRepository {

    suspend fun getPopularMovies(
        page: Int
    ): Result<MovieResponse>

}