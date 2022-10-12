package com.kefelon.themovieapp.core.data.repository

import com.kefelon.themovieapp.core.model.MovieDetail
import com.kefelon.themovieapp.core.model.MovieResponse


interface TMDBRepository {

    suspend fun getPopularMovies(
        page: Int
    ): Result<MovieResponse>

    suspend fun getNowPlayingMovies(
        page: Int
    ): Result<MovieResponse>

    suspend fun getTopRatedMovies(
        page: Int
    ): Result<MovieResponse>

    suspend fun getUpcomingMovies(
        page: Int
    ): Result<MovieResponse>

    suspend fun getMovieDetail(
        movieId: String
    ): Result<MovieDetail>

    suspend fun getFavoriteMovies(): List<MovieDetail>

    fun setFavoriteMovie(movieDetail: MovieDetail)

    fun deleteFavoriteMovie(movieDetail: MovieDetail)

}