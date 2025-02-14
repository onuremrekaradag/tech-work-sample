package com.kefelon.themovieapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kefelon.themovieapp.base.BaseViewModel
import com.kefelon.themovieapp.core.data.repository.TMDBRepositoryImpl
import com.kefelon.themovieapp.core.model.Movie
import com.kefelon.themovieapp.core.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val tmdbRepository: TMDBRepositoryImpl
) : BaseViewModel(tmdbRepository) {

    var movieId: Int? = null
    var isFavorite: Boolean = false
    val movieDetailLiveData = MutableLiveData<MovieDetail>()

    val processSuccess = MutableLiveData<String>()
    val processError = MutableLiveData<String>()


    init {

    }

    fun getMovieDetail() {
        viewModelScope.launch {
            tmdbRepository.getMovieDetail(movieId.toString()).onSuccess {
                movieDetailLiveData.value = it
            }
                .onFailure {
                    processError.value = it.message
                }
        }
    }

    fun triggerFavoriteMovieRoom() {
        if (isFavorite) {
            processSuccess.value = "Movie removed from your favorites."
            movieDetailLiveData.value?.let { tmdbRepository.deleteFavoriteMovie(it) }
        } else {
            processSuccess.value = "Movie added to your favorites."
            movieDetailLiveData.value?.let { tmdbRepository.setFavoriteMovie(it) }
        }
    }


}
