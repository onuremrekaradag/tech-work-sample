package com.kefelon.themovieapp.ui.main.fragment.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kefelon.themovieapp.base.BaseViewModel
import com.kefelon.themovieapp.core.data.repository.TMDBRepositoryImpl
import com.kefelon.themovieapp.core.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val tmdbRepository: TMDBRepositoryImpl
) : BaseViewModel(tmdbRepository) {

    var popularMoviesLoadMore = false
    val popularMoviesLiveData = MutableLiveData<ArrayList<Movie>>()

    var nowPlayingMoviesLoadMore = false
    val nowPlayingMoviesLiveData = MutableLiveData<ArrayList<Movie>>()

    var topRatedMoviesLoadMore = false
    val topRatedMoviesLiveData = MutableLiveData<ArrayList<Movie>>()

    var upcomingMoviesLoadMore = false
    val upcomingMoviesLiveData = MutableLiveData<ArrayList<Movie>>()

    val processError = MutableLiveData<String>()


    init {
        getPopularMovieList(1)
        getNowPlayingList(1)
        getTopRatedMovies(1)
        getUpcomingMovies(1)
    }

    fun getPopularMovieList(page: Int) {
        viewModelScope.launch {
            tmdbRepository.getPopularMovies(page).onSuccess {
                popularMoviesLiveData.value = it.results
                popularMoviesLoadMore = it.results.size >= 20
            }
                .onFailure {
                    processError.value = it.message
                }
        }
    }

    fun getNowPlayingList(page: Int) {
        viewModelScope.launch {
            tmdbRepository.getNowPlayingMovies(page).onSuccess {
                nowPlayingMoviesLiveData.value = it.results
                nowPlayingMoviesLoadMore = it.results.size >= 20
            }
                .onFailure {
                    processError.value = it.message
                }
        }
    }

    fun getTopRatedMovies(page: Int) {
        viewModelScope.launch {
            tmdbRepository.getTopRatedMovies(page).onSuccess {
                topRatedMoviesLiveData.value = it.results
                topRatedMoviesLoadMore = it.results.size >= 20
            }
                .onFailure {
                    processError.value = it.message
                }
        }
    }

    fun getUpcomingMovies(page: Int) {
        viewModelScope.launch {
            tmdbRepository.getUpcomingMovies(page).onSuccess {
                upcomingMoviesLiveData.value = it.results
                upcomingMoviesLoadMore = it.results.size >= 20
            }
                .onFailure {
                    processError.value = it.message
                }
        }
    }


}
