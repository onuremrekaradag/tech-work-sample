package com.kefelon.themovieapp.ui.main.fragment.favorite_movies

import androidx.fragment.app.viewModels
import com.kefelon.themovieapp.R
import com.kefelon.themovieapp.base.BaseFragment
import com.kefelon.themovieapp.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMoviesFragment :
    BaseFragment<FragmentMoviesBinding, FavoriteMoviesViewModel>() {

    override val mViewModel: FavoriteMoviesViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_favorite_movies

    override fun init() {

    }

}