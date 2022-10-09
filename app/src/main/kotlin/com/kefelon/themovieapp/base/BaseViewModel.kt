package com.kefelon.themovieapp.base

import androidx.lifecycle.ViewModel
import com.kefelon.themovieapp.core.data.repository.TMDBRepositoryImpl

abstract class BaseViewModel(private val repository: TMDBRepositoryImpl) : ViewModel() {

}

