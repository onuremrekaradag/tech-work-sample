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

    var loadMore = false
    val popularMoviesLiveData = MutableLiveData<ArrayList<Movie>>()


    init {
        getMovieList(1)
    }

    fun getMovieList(page: Int) {
        viewModelScope.launch {
            tmdbRepository.getPopularMovies(page).onSuccess {
                popularMoviesLiveData.value = it.results
                loadMore = it.results.size >= 20
            }
                .onFailure {
                    Timber.e("deneme")
                }
        }
    }


}
