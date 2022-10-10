package com.kefelon.core.network.service

import com.kefelon.themovieapp.core.model.MovieDetail
import com.kefelon.themovieapp.core.model.MovieResponse
import retrofit2.http.*

interface TMDBService {
    companion object {

        //region endpoints
        private const val MOVIE_BASE_URL = "/3/movie/"
        const val GET_POPULAR_MOVIES = MOVIE_BASE_URL + "popular"
        const val GET_NOW_PLAYING_MOVIES = MOVIE_BASE_URL + "now_playing"
        const val GET_TOP_RATED_MOVIES = MOVIE_BASE_URL + "top_rated"
        const val GET_UP_COMING_MOVIES = MOVIE_BASE_URL + "upcoming"
        const val GET_MOVIE_DETAIL = MOVIE_BASE_URL + "{movie_id}"
        //endregion


        //region request params
        const val REQUEST_PAGE = "page"
        const val REQUEST_MOVIE_ID = "movie_id"
        //endregion


    }

    @GET(GET_POPULAR_MOVIES)
    suspend fun getPopularMovies(
        @Query(REQUEST_PAGE) page: Int
    ): Result<MovieResponse>

    @GET(GET_NOW_PLAYING_MOVIES)
    suspend fun getNowPlayingMovies(
        @Query(REQUEST_PAGE) page: Int
    ): Result<MovieResponse>

    @GET(GET_TOP_RATED_MOVIES)
    suspend fun getTopRatedMovies(
        @Query(REQUEST_PAGE) page: Int
    ): Result<MovieResponse>

    @GET(GET_UP_COMING_MOVIES)
    suspend fun getUpcomingMovies(
        @Query(REQUEST_PAGE) page: Int
    ): Result<MovieResponse>

    @GET(GET_MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path(REQUEST_MOVIE_ID) movieId: String
    ): Result<MovieDetail>
}