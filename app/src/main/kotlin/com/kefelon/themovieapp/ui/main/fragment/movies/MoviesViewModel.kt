package com.kefelon.themovieapp.ui.main.fragment.movies

import androidx.lifecycle.viewModelScope
import com.kefelon.themovieapp.base.BaseViewModel
import com.kefelon.themovieapp.core.data.repository.TMDBRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val tmdbRepository: TMDBRepositoryImpl
) : BaseViewModel(tmdbRepository) {

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch {
            tmdbRepository.getPopularMovies(1).onSuccess {
                Timber.e("deneme")
            }
                .onFailure {
                    Timber.e("deneme")

                }
        }
    }


}
