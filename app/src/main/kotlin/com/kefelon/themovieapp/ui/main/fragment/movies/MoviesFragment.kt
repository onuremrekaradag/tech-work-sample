package com.kefelon.themovieapp.ui.main.fragment.movies

import androidx.fragment.app.viewModels
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseFragment
import com.kefelon.themovieapp.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment :
    BaseFragment<FragmentMoviesBinding, MoviesViewModel>() {

    override val mViewModel: MoviesViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_movies

    override fun init() {

    }

}