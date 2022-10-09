package com.kefelon.themovieapp.core.data.repository

import androidx.annotation.WorkerThread
import com.kefelon.core.network.service.TMDBService
import com.kefelon.themovieapp.core.model.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TMDBRepositoryImpl @Inject constructor(
    private val tmdbService: TMDBService,
) : TMDBRepository {

    override suspend fun getPopularMovies(page: Int): Result<MovieResponse> {
        return tmdbService.getPopularMovies(1)
    }


}
