package com.kefelon.themovieapp.core.data.repository

import com.kefelon.core.network.service.TMDBService
import com.kefelon.themovieapp.core.database.dao.MovieDao
import com.kefelon.themovieapp.core.model.MovieDetail
import com.kefelon.themovieapp.core.model.MovieResponse
import javax.inject.Inject

class TMDBRepositoryImpl @Inject constructor(
    private val tmdbService: TMDBService,
    // private val movieDao: MovieDao,
) : TMDBRepository {

    override suspend fun getPopularMovies(page: Int): Result<MovieResponse> {
        return tmdbService.getPopularMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int): Result<MovieResponse> {
        return tmdbService.getNowPlayingMovies(page)
    }

    override suspend fun getTopRatedMovies(page: Int): Result<MovieResponse> {
        return tmdbService.getTopRatedMovies(page)
    }

    override suspend fun getUpcomingMovies(page: Int): Result<MovieResponse> {
        return tmdbService.getUpcomingMovies(page)
    }

    override suspend fun getMovieDetail(movieId: String): Result<MovieDetail> {
        return tmdbService.getMovieDetail(movieId)
    }

    override suspend fun getFavoriteMovies(): List<MovieDetail> {
        // return movieDao.getAll()

        return arrayListOf()
    }

    override fun setFavoriteMovie(movieDetail: MovieDetail) {
        // movieDao.insertMovie(movieDetail)
    }

    override fun deleteFavoriteMovie(movieDetail: MovieDetail) {
        //movieDao.delete(movieDetail)

    }


}
