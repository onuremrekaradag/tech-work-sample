package com.kefelon.themovieapp.ui.main.fragment.favorite_movies

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
class FavoriteMoviesViewModel @Inject constructor(
    private val tmdbRepository: TMDBRepositoryImpl
) : BaseViewModel(tmdbRepository) {


    val favoriteMoviesLiveData = MutableLiveData<List<MovieDetail>>()

    val processError = MutableLiveData<String>()


    init {
        getFavoriteMovieList()

    }

    fun getFavoriteMovieList() {
        viewModelScope.launch {
            favoriteMoviesLiveData.value = tmdbRepository.getFavoriteMovies()
            if (tmdbRepository.getFavoriteMovies().isEmpty()) processError.value =
                "Add movies to favorites to see them here."
        }
    }


}
